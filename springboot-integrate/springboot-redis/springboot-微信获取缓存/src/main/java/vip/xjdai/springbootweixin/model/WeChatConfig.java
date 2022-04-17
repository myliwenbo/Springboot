package vip.xjdai.springbootweixin.model;

import lombok.Data;

@Data
public class WeChatConfig {

    public static final String MODEL_MODEL = "pamirs.eip.WeChatConfig";

    private String name;


    private String agentId;

    private String appKey;

    private String appId;

    private String appSecret;

    private String snsRedirectUrl;

    private String url;
}
