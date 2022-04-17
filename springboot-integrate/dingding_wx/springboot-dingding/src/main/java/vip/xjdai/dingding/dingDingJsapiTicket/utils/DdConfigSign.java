package vip.xjdai.dingding.dingDingJsapiTicket.utils;


import vip.xjdai.dingding.dingDingJsapiTicket.model.DingdingJSAPIVO;

import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Formatter;
import java.util.Random;

/**
 * 计算dd.config的签名参数
 **/
public class DdConfigSign {
    private static String nonceStr = "5DC7E5E89FFB4915993BA0C765601799";

    /**
     * 计算dd.config的签名参数
     *
     * @param jsticket 通过微应用appKey获取的jsticket
     * @param url      调用dd.config的当前页面URL
     * @return
     * @throws Exception
     */
    public static void sign(String jsticket, DingdingJSAPIVO dingdingJSAPIVO) throws Exception {
        dingdingJSAPIVO.setNonceStr(nonceStr);
        dingdingJSAPIVO.setTimeStamp(new Date().getTime() + "");
        StringBuilder plain = new StringBuilder();
        plain.append("jsapi_ticket=");
        plain.append(jsticket);
        plain.append("&noncestr="); // 自定义固定字符串
        plain.append(nonceStr);
        plain.append("&timestamp="); // 当前时间戳
        plain.append(dingdingJSAPIVO.getTimeStamp());
        plain.append("&url=");
        plain.append(decodeUrl(dingdingJSAPIVO.getUrl()));
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-256");
            sha1.reset();
            sha1.update(plain.toString().getBytes(StandardCharsets.UTF_8));
            dingdingJSAPIVO.setSignature(byteToHex(sha1.digest()));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // 字节数组转化成十六进制字符串
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    /**
     * 因为ios端上传递的url是encode过的，android是原始的url。开发者使用的也是原始url,
     * 所以需要把参数进行一般urlDecode
     *
     * @param url
     * @return
     * @throws Exception
     */
    private static String decodeUrl(String url) throws Exception {
        URL urler = new URL(url);
        StringBuilder urlBuffer = new StringBuilder();
        urlBuffer.append(urler.getProtocol());
        urlBuffer.append(":");
        if (urler.getAuthority() != null && urler.getAuthority().length() > 0) {
            urlBuffer.append("//");
            urlBuffer.append(urler.getAuthority());
        }
        if (urler.getPath() != null) {
            urlBuffer.append(urler.getPath());
        }
        if (urler.getQuery() != null) {
            urlBuffer.append('?');
            urlBuffer.append(URLDecoder.decode(urler.getQuery(), "utf-8"));
        }
        return urlBuffer.toString();
    }

    public static String getRandomStr(int count) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}