package cn.lwb.solr.test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

/**
 * 主要就是增、删、更
 * @author lwb
 *
 */
public class SolrUtils {

    //指定solr服务器的地址
    private final static String SOLR_URL = "http://192.168.6.132:8080/solr/";

    /**
     * 创建SolrServer对象
     * <p>
     * 该对象有两个可以使用，都是线程安全的
     * 1、CommonsHttpSolrServer：启动web服务器使用的，通过http请求的
     * 2、 EmbeddedSolrServer：内嵌式的，导入solr的jar包就可以使用了
     */
    public static HttpSolrClient createSolrServer(String solrCore) {
        HttpSolrClient solr = null;
        solr = new HttpSolrClient.Builder(SOLR_URL + solrCore).build();
        return solr;
    }

    public static HttpSolrClient createSolrServer() {
        return createSolrServer("new_core");
    }

    /**
     * 往索引库添加文档
     * @param <T>
     */
    public static <T> void addDoc(T t) throws Exception {
        if (null != t) {
            //获取所有属性
            Field[] declaredFields = t.getClass().getDeclaredFields();
            //构造一篇文档
            SolrInputDocument document = new SolrInputDocument();
            //遍历所有属性
            for (Field f : declaredFields) {
                f.setAccessible(true);
                Object val = f.get(t);
                if (val != null) {
                    //往doc中添加字段,在客户端这边添加的字段必须在服务端中有过定义
                    document.addField(f.getName(), val);
                }
            }
            //获得一个solr服务端的请求，去提交  ,选择具体的某一个solr core
            HttpSolrClient solr = createSolrServer();
            solr.add(document);
            solr.commit();
            solr.close();
        }
    }

    /**
     * 往索引库添加文档
     * @param <T>
     */
    public static <T> void addPOJODoc(T t) throws Exception {
        //获得一个solr服务端的请求，去提交  ,选择具体的某一个solr core
        HttpSolrClient solr = createSolrServer();
        solr.addBean(t);
        solr.commit();
        solr.close();
    }

    /**
     * 根据id从索引库删除文档
     */
    public static void deleteDocumentById(String id) throws Exception {
        //选择具体的某一个solr core
        HttpSolrClient server = createSolrServer();
        //删除文档
        server.deleteById(id);
        //删除所有的索引
        //solr.deleteByQuery("*:*");
        //提交修改
        server.commit();
        server.close();
    }

    /**
     * 更新文档，其实就是根据ID重新set值去了
     * @param t
     * @throws Exception
     */
    public static <T> void uodateDocumentById(T t) throws Exception {
        if (null != t) {
            //获取所有属性
            Field[] declaredFields = t.getClass().getDeclaredFields();
            //构造一篇文档
            SolrInputDocument document = new SolrInputDocument();
            for (Field f : declaredFields) {
                f.setAccessible(true);
                Object val = f.get(t);
                if (val != null) {
                    //往doc中添加字段,在客户端这边添加的字段必须在服务端中有过定义
                    document.addField(f.getName(), val);
                }
            }
            //获得一个solr服务端的请求，去提交  ,选择具体的某一个solr core
            HttpSolrClient solr = createSolrServer();
            solr.add(document);
            solr.commit();
            solr.close();
        }
    }

    public static void executeSolr(SolrQuery solrQuery) throws Exception {
        //获取一个solr_core
        HttpSolrClient client = SolrUtils.createSolrServer();
        //执行搜索
        QueryResponse response = client.query(solrQuery);
        //结果输出
        SolrUtils.resultPrint(response);
    }

    public static void resultPrint(QueryResponse response) {
        // 搜索结果，查询得到文档的集合
        SolrDocumentList solrDocumentList = response.getResults();
        System.out.println("通过文档集合获取查询的结果");
        System.out.println("查询结果的总数量：" + solrDocumentList.getNumFound());
        // 遍历列表
        for (SolrDocument doc : solrDocumentList) {
            System.out.println(doc.toString());
        }
        //高亮数据
        // 获取查询出所有的高亮结果集
        Map<String, Map<String, List<String>>> map = response.getHighlighting();
        for (SolrDocument solrDocument : solrDocumentList) {
            // 获取高亮数据
            List<String> hlight = map.get(solrDocument.get("id")).get("name");
            System.out.println("高亮的数据：" + hlight.get(0));//显示高亮数据
        }
    }

}
