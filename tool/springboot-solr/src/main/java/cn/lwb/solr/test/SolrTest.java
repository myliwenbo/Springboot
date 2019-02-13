package cn.lwb.solr.test;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

import cn.lwb.solr.entity.SolrQueryDecorated;

public class SolrTest {

    public static SolrQuery query(String... value) throws Exception {
        SolrQuery query = SolrQueryDecorated.setQ(value);
        // 参数sort,设置返回结果的排序规则
        query.setSort("id", SolrQuery.ORDER.desc);
        // 开启高亮
        query.setHighlight(true);
        query.addHighlightField("name"); // 设置高亮的字段
        query.setHighlightSimplePre("<font color='red'>"); //设置高亮的样式
        query.setHighlightSimplePost("</font>");
        // 设置分页参数
        query.setStart(0);
        // 每一页多少值
        query.setRows(5);
        return query;
    }

    /**
     * 联想查询
     * @param value
     * @return 
     * @throws Exception
     */
    @SuppressWarnings("unused")
    public static SolrQuery querExample() throws Exception {
        // 这个作用适用于联想查询
        //关键字OR
        SolrQuery or = query("name:周新星  OR name:小明");
        //查询name包含小明的
        SolrQuery nameOne = query("name", "小明");
        //查询所有
        SolrQuery all = query("*:*");
        //查询name字段
        SolrQuery nameAll = query("name:*");
        return nameAll;

    }

    /**
     * 查询
     *
     * @throws Exception
     */
    public static void querySolr() throws Exception {
        HttpSolrClient solrServer = SolrUtils.createSolrServer();
        SolrQuery query = new SolrQuery();
        // 相关查询，比如某条数据某个字段含有周、星、驰三个字  将会查询出来 ，这个作用适用于联想查询
        query.set("q", "*:*");

        // 参数df,默认的查询字段
        query.set("df", "name");

        // 参数sort,设置返回结果的排序规则
        query.setSort("id", SolrQuery.ORDER.desc);

        // 设置分页参数
        query.setStart(0);
        // 每一页多少值
        query.setRows(10);

        // 参数hl,设置高亮
        query.setHighlight(true);
        // 设置高亮的字段
        query.addHighlightField("name");
        // 设置高亮的样式
        query.setHighlightSimplePre("<font color='red'>");
        query.setHighlightSimplePost("</font>");
        // 获取查询结果
        QueryResponse response = solrServer.query(query);
        // 两种结果获取：得到文档集合或者实体对象
        SolrUtils.resultPrint(response);
        solrServer.close();
    }

    public static void main(String[] args) throws Exception {
        //        User user = new User();
        //        user.setId(UUID.randomUUID().toString());
        //        user.setName("周星波");
        //        user.setPassword(UUID.randomUUID().toString());
        //        SolrUtils.addPOJODoc(user);
        //                SolrUtils.deleteDocumentById("change.me");
        //                User user = new User();
        //                user.setId("8");
        //                user.setName("小明AAA");
        //                user.setPassword(UUID.randomUUID().toString());
        //                SolrUtils.uodateDocumentById(user);

        SolrUtils.executeSolr(querExample());

    }

}
