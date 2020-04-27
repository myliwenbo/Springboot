package vip.xjdai.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.http.Consts;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpClientUtil {
    private static int    connectionTimeout;
    private static int    timeout;
    private static String default_charset;
    private static int    sc_ok = 200;

    static {
        HttpClientUtil.connectionTimeout = 8000;
        HttpClientUtil.timeout = 16000;
        HttpClientUtil.default_charset = "UTF-8";
    }

    public static String sendGet(final String url, final Map<String, String> dataParam)
    {

        boolean hasError = false;
        final long startTime = System.currentTimeMillis();
        final HttpClient httpClient = new HttpClient();
        final HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams();
        managerParams.setConnectionTimeout(HttpClientUtil.connectionTimeout);
        managerParams.setSoTimeout(HttpClientUtil.timeout);
        final GetMethod method = new GetMethod(url);
        try {
            if (dataParam != null) {
                //拼接参数
                method.setQueryString(createLinkString(dataParam));
            }
            //执行请求
            httpClient.executeMethod((HttpMethod) method);
            return method.getResponseBodyAsString().trim();
        } catch (HttpException e) {
            hasError = true;
            log.error("远程查询服务器失败：[url] " + url, (Throwable) e);
        } catch (IOException e2) {
            hasError = true;
            log.error("远程查询服务器超时：[url]" + url, (Throwable) e2);
        } finally {
            method.releaseConnection();
            httpClient.getHttpConnectionManager().closeIdleConnections(0L);
            final long elapseTime = System.currentTimeMillis() - startTime;
            log.info("(" + url + (hasError ? ",N," : ",Y,") + elapseTime + "ms)");
        }
        return null;
    }

    /**
     * 传递对象
     * @param url
     * @param entity
     * @return
     */
    public static String sendPostWithJson(final String url, final Object entity)
    {
        String json = JSONUtil.toJson(entity);
        return sendPostWithJson(url, json);
    }

    /**
     * 
     * 发送Post请求请求协议为JSON类型
     * @param url
     * @param entity
     * @return
     */
    public static String sendPostWithJson(final String url, final String entityJson)
    {
        boolean hasError = false;
        final long startTime = System.currentTimeMillis();
        //设置请求
        final HttpPost post = new HttpPost(url);
        //获取HttpClient客户端
        final CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            //封装请求参数
            final StringEntity se = new StringEntity(entityJson, Consts.UTF_8);
            //设置请求的编码
            se.setContentEncoding(new BasicHeader("Content-Encoding", Consts.UTF_8.toString()));
            //设置请求头类型
            se.setContentType(new BasicHeader("Content-Type", "application/json;charset=UTF-8"));
            //设置请求参数
            post.setEntity(se);
            //发送求情
            response = client.execute(post);
            final int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpClientUtil.sc_ok) {
                return EntityUtils.toString(response.getEntity());
            }
            hasError = true;
            HttpClientUtil.log.warn("远程查询服务器失败：[url] " + url + " ;[statusCode] " + statusCode);
            return null;
        } catch (ClientProtocolException e) {
            hasError = true;
            post.abort();
            HttpClientUtil.log.error("远程查询服务器失败：[url] " + url, (Throwable) e);
        } catch (IOException e2) {
            hasError = true;
            post.abort();
            HttpClientUtil.log.error("远程查询服务器超时：[url]" + url, (Throwable) e2);
        } finally {
            try {
                client.close();
            } catch (IOException e3) {
                HttpClientUtil.log.error("远程查询服务器，资源释放异常：[url] " + url, (Throwable) e3);
            }
            post.releaseConnection();
            final long elapseTime = System.currentTimeMillis() - startTime;
            HttpClientUtil.log.info("(" + url + (hasError ? ",N," : ",Y,") + elapseTime + "ms)");
        }
        return null;
    }

    public static String createLinkString(final Map<String, String> dataParam) throws UnsupportedEncodingException
    {
        final List<String> keys = new ArrayList<String>(dataParam.keySet());
        Collections.sort(keys);
        String prestr = "";
        for (int i = 0; i < keys.size(); ++i) {
            final String key = keys.get(i);
            final String value = URLEncoder.encode(dataParam.get(key), HttpClientUtil.default_charset);
            if (i == keys.size() - 1) {
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }
}