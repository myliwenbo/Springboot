package vip.xjdai.springbootweixin.model;


import lombok.Data;

import java.util.List;

@Data
/**
 * @author: 567
 * @date: 2022/2/26
 * @version: 1.0.0
 */
public class WechatAuthCheckConfig {
    public static final String MODEL_MODEL = "pamirs.eip.WechatAuthCheckConfig";

    private String appKey;

    private String appId;

    private String url;

    private String accessToken;

    private String expiresIn;

    private String timestamp;

    private String nonceStr;

    private String signature;

    private List<String> jsApiList;
}
