package vip.xjdai.springboothttpclietn.utils;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.util.function.Supplier;

@Log4j2
public class HttpClientUtils {


    public static void sendGet(Supplier<HttpRequestBase> function) {
        // 将参数放入键值对类NameValuePair中,再放入集合中
        CloseableHttpClient client = getClient();
        // 创建Get请求
        HttpRequestBase requestBase = function.get();
        requestBase.setConfig(getConfig());
        execute(requestBase, client);
    }

    /**
     * 关闭流，并且打印数据
     *
     * @param httpGet
     * @param client
     */
    @SneakyThrows
    public static void execute(HttpRequestBase httpGet, CloseableHttpClient client) {
        // 执行请求
        try (CloseableHttpResponse response = client.execute(httpGet)) {
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            log.info("响应状态为:{}", response.getStatusLine());
            log.info("响应内容长度为:{}", responseEntity.getContentLength());
            log.info("响应内容为:{}", EntityUtils.toString(responseEntity, "UTF-8"));
        } finally {
            // 关闭请求
            client.close();
        }
    }


    /**
     * 创建 CttpClient
     *
     * @return
     */
    public static CloseableHttpClient getClient() {
        // CloseableHttpClient的生成器
        CloseableHttpClient build = HttpClientBuilder.create()
                .setMaxConnTotal(10) //指定最大总连接值
                .setDefaultRequestConfig(getConfig()) // 设置默认的请求 配置
                // 需要注意的 SSLSocketFactory 和 ConnectionManager 是互斥的
                .setSSLSocketFactory(ssl())  // 设置SSL管理工厂
                // 需要注意的 SSLSocketFactory 和 ConnectionManager 是互斥的
                .setConnectionManager(getConnectionManager()) // 设置连接管理器
                .build();
        return build;
    }

    public static PoolingHttpClientConnectionManager getConnectionManager() {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        // 设置最大连接池的数量
        connectionManager.setMaxTotal(10000);
        // 每个主机的最大并发量，route是指域名。-- 对MaxTotal的细化
        // 每个域名的请求最大为 3000
        connectionManager.setDefaultMaxPerRoute(3000);
        //validateAfterInactivity 空闲永久连接检查间隔
        //官方推荐使用这个来检查永久链接的可用性，而不推荐每次请求的时候才去检查
        connectionManager.setValidateAfterInactivity(10);
        return connectionManager;
    }

    public static RequestConfig getConfig() {
        // 配置信息
        RequestConfig requestConfig = RequestConfig.custom()
                // 设置连接超时时间(单位毫秒)
                .setConnectTimeout(5000)
                // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(5000)
                // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)
                // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(true).build();
        return requestConfig;

    }

    /**
     * 使用 SSLConnectionSocketFactory 跳过SSL证书认证。
     *
     * @return
     */
    @SneakyThrows
    public static SSLConnectionSocketFactory ssl() {
        //信任所有
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (chain, authType) -> true).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
        return sslsf;
    }
}
