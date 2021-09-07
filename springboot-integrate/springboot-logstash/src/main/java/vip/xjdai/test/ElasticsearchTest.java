/**
 * 
 */
package vip.xjdai.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lwb
 *
 */
@Slf4j
public class ElasticsearchTest {

    public final static String HOST   = "192.168.6.132";
    public final static int    PORT   = 9300;           //http请求的端口是9200，客户端是9300   

    private TransportClient    client = null;

    /*** 获取客户端连接信息*/
    @Before
    public void getConnect() throws UnknownHostException {
        client = new PreBuiltTransportClient(Settings.EMPTY);
        client
            .addTransportAddress(new TransportAddress(InetAddress.getByName(HOST), PORT));
        log.info("连接成功");
    }

    /**
    * 关闭连接
    */
    @After
    public void closeConnect() {
        if (null != client) {
            log.info("执行关闭连接操作...");
            client.close();
        }
    }

    @Test
    public void addIndex() throws IOException {
        IndexResponse response = client.prepareIndex("tx_application", "user", "1")
            .setSource(XContentFactory.jsonBuilder().startObject()
                .field("userName", "Rock").field("msg", "I am Rock_JieGe").endObject())
            .get();
        log.info("索引名称:" + response.getIndex() + "\n类型:" + response.getType() + "\n文档ID:"
                 + response.getId() + "\n当前实例状态:" + response.status());
    }

    /*** 从索引库获取数据*/
    @Test
    public void getData() {
        GetResponse getResponse = client.prepareGet("tx_application", "user", "1").get();
        log.info("索引库的数据:" + getResponse.getSourceAsString());
    }

    /*** 更新索引库数据*/
    @Test
    public void updateData() {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", "Doug Lee");
        map.put("sendDate", "20180411");
        map.put("msg", "I am Doug Lee");
        String jsonString = JSON.toJSONString(map);
        UpdateResponse updateResponse = client
            .prepareUpdate("tx_application", "user", "1")
            .setDoc(jsonString, XContentType.JSON).get();
        log.info("updateResponse索引名称:" + updateResponse.getIndex()
                 + "\n updateResponse类型:" + updateResponse.getType()
                 + "\n updateResponse文档ID:" + updateResponse.getId()
                 + "\n当前实例updateResponse状态:" + updateResponse.status());
    }

    /*** 根据索引名称，类别，文档ID 删除索引库的数据*/
    @Test
    public void deleteData() {
        DeleteResponse deleteResponse = client
            .prepareDelete("tx_application", "user", "1").get();
        log.info("deleteResponse索引名称:" + deleteResponse.getIndex()
                 + "\n deleteResponse类型:" + deleteResponse.getType()
                 + "\n deleteResponse文档ID:" + deleteResponse.getId()
                 + "\n当前实例deleteResponse状态:" + deleteResponse.status());
    }

    /*** 添加索引json格式的*/
    @Test
    public void addIndexJson() {
        String jsonStr = "{" + "\"userName\":\"MiLi\"," + "\"sendDate\":\"2017-04-18\","
                         + "\"msg\":\"MiLi say Hello word\"" + "}";
        IndexResponse response = client.prepareIndex("county", "xian")
            .setSource(jsonStr, XContentType.JSON).get();
        log.info("json索引名称:" + response.getIndex() + "\njson类型:" + response.getType()
                 + "\njson文档ID:" + response.getId() + "\n当前实例json状态:"
                 + response.status());
    }

}
