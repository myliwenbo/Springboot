package vip.xjdai.springbootinitializr.WxDemo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import jdk.nashorn.internal.objects.annotations.Function;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import vip.xjdai.springbootinitializr.WxDemo.model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Formatter;
import java.util.UUID;

/**
 * @author: 567
 * @date: 2022/2/26
 * @version: 1.0.0
 */
@Component
public class WechatAuthCheckConfigServiceImpl implements WechatAuthCheckConfigService {

    public static final String SPLIT = "jsapi_ticket=[TICKET]&noncestr=[NONCESTR]&timestamp=[TIMESTAMP]&url=[URL]";
    public static final String ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=[APPID]&secret=[APPSECRET]";
    public static final String JSAPI_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=[ACCESS_TOKEN]&type=jsapi";


    @Function
    @Override
    public WechatAuthCheckConfig generateSignature(WechatAuthCheckConfig config) {

        WeChatConfig weChatConfig = new WechatConfigServiceImpl().queryByAppId(config.getAppId());
        // 2.获取Access token
        String accessToken = getToken(ACCESS_TOKEN.replace("[APPID]", weChatConfig.getAppId())
                .replace("[APPSECRET]", weChatConfig.getAppSecret()));
        // 3. 获取 JAPI
        String ticket = getTicket(JSAPI_TICKET.replace("[ACCESS_TOKEN]", accessToken));
        getSignature(ticket, weChatConfig.getUrl(), config);
        return config;
    }

    /**
     * 通过url获取Access_Token 或 Ticket
     *
     * @param url 请求url
     * @return
     */
    private String getToken(String url) {
        TypeReference<WXAccessToken> typeReference = new TypeReference<WXAccessToken>() {
        };
        WXAccessToken wxAccessToken = wxGet(url, typeReference);
        return wxAccessToken.getAccessToken();
    }

    private String getTicket(String url) {
        WXJsapiResponse wxJsapiResponse = wxGet(url, new TypeReference<WXJsapiResponse>() {
        });
        return wxJsapiResponse.getTicket();
    }

    private <T extends WXBaseResponse> T wxGet(String url, TypeReference<T> type) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            T wxAccessToken = JSONObject.parseObject(responseBody, type);
            if (wxAccessToken.isSuccess()) {
                return wxAccessToken;
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过算法生成JS-SDK权限验证的签名
     * 需要：noncestr（随机字符串）,
     * 有效的jsapi_ticket,
     * timestamp（时间戳）,
     * url（当前网页的URL，不包含#及其后面部分）
     * 加密算法:
     * 1) 对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，
     * 使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串
     * 2) 对string1进行sha1签名
     * <p>
     * "jsapi_ticket=[TICKET]&noncestr=[NONCESTR]&timestamp=[TIMESTAMP]&url=[URL]";
     */
    private void getSignature(String ticket, String url, WechatAuthCheckConfig config) {
        // 1.获取随机字符串
        config.setNonceStr(UUID.randomUUID().toString());
        // 2.获取时间戳
        config.setTimestamp(System.currentTimeMillis() / 1000 + "");
        // 3.SHA1加密得到签名
        String signature = getSHA1Encode(SPLIT.replace("[TICKET]", ticket)
                .replace("[NONCESTR]", config.getNonceStr())
                .replace("[TIMESTAMP]", config.getTimestamp())
                .replace("[URL]", url));
        config.setSignature(signature);
    }

    /**
     * SHA1加密算法
     *
     * @param str 需要加密的字符串
     * @return
     */
    private String getSHA1Encode(String str) {
        String signature;
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(str.getBytes(StandardCharsets.UTF_8));
            signature = byteToHex(crypt.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return signature;
    }


    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
