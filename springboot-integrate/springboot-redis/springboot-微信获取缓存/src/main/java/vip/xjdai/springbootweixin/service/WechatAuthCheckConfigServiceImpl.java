package vip.xjdai.springbootweixin.service;

import com.alibaba.fastjson.JSON;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import vip.xjdai.springbootweixin.model.*;

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
public class WechatAuthCheckConfigServiceImpl {

    public static final String SPLIT = "jsapi_ticket=[TICKET]&noncestr=[NONCESTR]&timestamp=[TIMESTAMP]&url=[URL]";
    public static final String ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=[APPID]&secret=[APPSECRET]";
    public static final String JSAPI_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=[ACCESS_TOKEN]&type=jsapi";

    private static final String WX_CONFIG = "WX:WX_CONFIG:";
    private static final String WX_ACCESS_TOKEN = "WX:ACCESS_TOKEN:";
    private static final String WX_JSAPI_TICKET = "WX:JSAPI_TICKET:";
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private WechatConfigService wechatConfigService;

    public WechatAuthCheckConfig generateSignature(WechatAuthCheckConfig config) {

        WeChatConfig weChatConfig = getWeChatConfig(config.getAppKey());
        // 2.获取Access token
        String accessToken = getToken(weChatConfig);
        // 3. 获取 JAPI
        String ticket = getTicket(accessToken);
        // 1. appId前端传递的是 appid对应的Key
        getSignature(ticket, config.getUrl(), config);
        config.setAppId(weChatConfig.getAppId());
        return config;
    }

    /**
     * 通过url获取Access_Token
     *
     * @param weChatConfig 微信配置信息
     * @return
     */
    private String getToken(WeChatConfig weChatConfig) {
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        String accessTokenJson = stringStringValueOperations.get(WX_ACCESS_TOKEN + weChatConfig.getAppKey());
        if (StringUtils.isEmpty(accessTokenJson)) {
            // 1. 设置微信请求的URL
            String url = ACCESS_TOKEN.replace("[APPID]", weChatConfig.getAppId())
                    .replace("[APPSECRET]", weChatConfig.getAppSecret());
            WXAccessToken wxAccessToken = this.wxGet(url, new TypeReference<WXAccessToken>() {
            });
            String accessToken = wxAccessToken.getAccessToken();
            // 设置过期时间，提前原来的时间，这样老旧都可以使用..
            stringStringValueOperations.set(WX_ACCESS_TOKEN + weChatConfig.getAppKey(), accessToken, wxAccessToken.getExpiresIn() - 100);
            return accessToken;
        }
        return accessTokenJson;
    }


    private String getTicket(String accessToken) {
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        String ticket = stringStringValueOperations.get(WX_JSAPI_TICKET + accessToken);
        if (StringUtils.isBlank(ticket)) {
            // 1. 设置微信请求的URL
            String url = JSAPI_TICKET.replace("[ACCESS_TOKEN]", accessToken);
            WXJsapiResponse wxJsapiResponse = this.wxGet(url, new TypeReference<WXJsapiResponse>() {
            });
            stringStringValueOperations.set(WX_JSAPI_TICKET + accessToken, wxJsapiResponse.getTicket(), wxJsapiResponse.getExpiresIn());
            return wxJsapiResponse.getTicket();
        }
        return ticket;
    }

    /**
     * 根据AppKey 获取 WX配置
     *
     * @param appKey 自定义的值，相当于 appId的掩码
     * @return
     */
    private WeChatConfig getWeChatConfig(String appKey) {
        //1. 先去缓存查询
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        String weChatConfigJson = stringStringValueOperations.get(WX_CONFIG + appKey);
        //2. 不存在去数据库查询，放入缓存中
        if (StringUtils.isEmpty(weChatConfigJson)) {
            WeChatConfig weChatConfig = wechatConfigService.queryByAppId(appKey);
            redisTemplate.opsForValue().set(WX_CONFIG + weChatConfig.getAppKey(), JSON.toJSONString(weChatConfig));
            return weChatConfig;
        } else {
            return JSON.parseObject(weChatConfigJson, WeChatConfig.class);
        }
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
                throw new RuntimeException(wxAccessToken.getErrmsg());
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
