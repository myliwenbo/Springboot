package cn.lwb.solrcloud;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.PivotField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.GroupParams;
import org.apache.solr.common.util.NamedList;
import org.junit.Test;

import cn.lwb.solr.entity.User;

public class SolrCloud {
    /**  
     * 连接 solrcloud  
     * @return  
     */
    @SuppressWarnings("null")
    public CloudSolrClient getCloudSolrClient() {
        CloudSolrClient csc = null;
        csc.setDefaultCollection("collection1");// 集合名称  
        return csc;
    }

    /**  
     * solrcloud 保存 修改 删除和单机相同  
     */
    @Test
    public void save() throws IOException, SolrServerException {
        CloudSolrClient csc = getCloudSolrClient();
        User ui = new User();
        ui.setId("4");
        ui.setName("王五");
        ui.setAge(100);
        csc.addBean(ui);
        csc.commit();
        csc.close();
    }

    /**  
     * solrcloud 删除  
     */
    //@Test  
    public void delete() throws IOException, SolrServerException {
        CloudSolrClient csc = getCloudSolrClient();
        csc.deleteByQuery("*:*");
        csc.commit();
        csc.close();
    }

    /**  
     * solrcloud 高亮显示  
     * 必须设置中文分词器  
     */
    @Test
    public void queryHign() throws IOException, SolrServerException {
        CloudSolrClient csc = getCloudSolrClient();
        SolrQuery sq = new SolrQuery();
        sq.setQuery("desc: 王五");
        sq.addHighlightField("desc");
        sq.setHighlight(true);
        sq.setHighlightSimplePre("<font color=red>");
        sq.setHighlightSimplePost("</font>");
        QueryResponse qr = csc.query(sq);
        List<User> userInfo = qr.getBeans(User.class);
        Map<String, Map<String, List<String>>> highlighting = qr.getHighlighting();
        System.out.println(highlighting);
        for (User ui : userInfo) {
            System.out.println(ui.getName());
        }
        System.out.println(userInfo.size());
        csc.commit();
        csc.close();
    }

    /**  
     * Facet 面 用于对搜索的结果进行分类   
     *  比如按国家分类   addFacetField 表示按某些字段进行分类是普通分类  结果为：  
     *   country  
            美国: 6  
            中国: 5  
        sq.addFacetQuery("age_i:[1 TO 20]");  
        sq.addFacetQuery("age_i:[21 TO 50]");  
        sq.addFacetQuery("age_i:[51 TO *]");  
        可以将多个范围值 添加到 FacetQuery 可以获取到这些 Query 的统计数量 比如  
         {age_i:[1 TO 20]=3, age_i:[20 TO 50]=5, age_i:[50 TO *]=5}   
        其他 参考 https://wiki.apache.org/solr/SimpleFacetParameters#facet.query_:_Arbitrary_Query_Faceting   
     */
    @Test
    public void queryFacet() throws IOException, SolrServerException {
        CloudSolrClient csc = getCloudSolrClient();
        SolrQuery sq = new SolrQuery();

        sq.setFacet(true);
        // 按字段分类 相同的归于一类  
        sq.addFacetField("country");
        // 特殊分类 添加范围  
        sq.addFacetQuery("age_i:[1 TO 20]");
        sq.addFacetQuery("age_i:[21 TO 50]");
        sq.addFacetQuery("age_i:[51 TO *]");
        // 这只 facet 字段分类的前缀  
        sq.setFacetPrefix("");
        // 根据 count 数量 升序和降序 也可以根据索引   
        sq.setFacetSort("count asc");
        sq.setQuery("*:*");
        QueryResponse qr = csc.query(sq);
        List<FacetField> ff = qr.getFacetFields();
        // 获取到范围分类的对应统计数量  
        System.out.println(qr.getFacetQuery());
        // 获取到根据字段分类的对应统计数量  
        for (FacetField ftmp : ff) {
            System.out.println(ftmp.getName());
            List<Count> cou = ftmp.getValues();
            for (Count count : cou) {
                System.out.println(count.getName() + ":" + count.getCount());
            }
        }
        csc.commit();
        csc.close();
    }

    /**  
     * Facet  参考 https://wiki.apache.org/solr/SimpleFacetParameters#Pivot_.28ie_Decision_Tree.29_Faceting  
     *  可以按照多维度来进行分类    
     *    比如按照国家分类后  再按照省份分类 (国家和省份字段不要使用中文分词器 否则分类被拆成很多类别)  
     *      
     *  结果一般为：  
     *    美国 6：  
     *      加利福尼亚州 3    
     *      德克萨斯州 3  
     *    中国 5：  
     *      湖南省 3  
     *      广东省 2  
    
     */
    @Test
    public void queryFacetPivot() throws IOException, SolrServerException {
        CloudSolrClient csc = getCloudSolrClient();
        SolrQuery sq = new SolrQuery();
        sq.setFacet(true);
        // 按国家和省份进行二维分类  同一个字符串使用, 隔开  
        sq.addFacetPivotField("country,provice");
        sq.setQuery("*:*");
        QueryResponse qr = csc.query(sq, SolrRequest.METHOD.POST);
        NamedList<List<PivotField>> ff = qr.getFacetPivot();
        // 获取到根据字段分类的对应统计数量  
        for (Map.Entry<String, List<PivotField>> me : ff) {
            List<PivotField> lpf = me.getValue();
            for (PivotField pf : lpf) {
                System.out.println("一级分类:" + pf.getValue() + pf.getCount() + "---->");
                List<PivotField> clpf = pf.getPivot();
                for (PivotField cpf : clpf) {
                    System.out.println("二级分类:" + cpf.getValue() + cpf.getCount());
                }
            }
        }
        csc.commit();
        csc.close();
    }

    /**  
     * 分组是分类的升级 同时可以获取到分组下的一部分元素（https://cwiki.apache.org/confluence/display/solr/Result+Grouping）  
       分组的字段的数据如果是集群环境 要求数据被写入到一个分片中 否则无法分组查询  
     */
    @Test
    public void queryGroup() throws IOException, SolrServerException {
        CloudSolrClient csc = getCloudSolrClient();
        SolrQuery sq = new SolrQuery();
        //sq.setParam("shards.tolerant", true);  
        sq.setParam(GroupParams.GROUP, true);
        sq.setParam(GroupParams.GROUP_FIELD, "country");
        sq.setParam("group.ngroups", true);
        //sq.setParam(GroupParams.GROUP_LIMIT, "5");  
        sq.setQuery("*:*");
        sq.setRows(10);
        QueryResponse qr = csc.query(sq);
        GroupResponse ff = qr.getGroupResponse();

        for (GroupCommand me : ff.getValues()) {
            System.out.println(me.getName());
            List<Group> groups = me.getValues();
            System.out.println(groups);

        }
        csc.commit();
        csc.close();
    }
}