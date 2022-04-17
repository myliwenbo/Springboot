package vip.xjdai.dingding.dingDingJsapiTicket.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DingdingJSAPIVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * url
     */
    private String url;
    /**
     * 必填，生成签名的时间戳
     */
    private String timeStamp;
    /**
     * 必填，自定义固定字符串。
     */
    private String nonceStr;
    /**
     * 必填，签名
     */
    private String signature;
}
