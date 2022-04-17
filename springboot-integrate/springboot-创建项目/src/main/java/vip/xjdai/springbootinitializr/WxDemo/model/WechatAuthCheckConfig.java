package vip.xjdai.springbootinitializr.WxDemo.model;

import lombok.Data;

import java.util.List;

@Data

/**
 * @author: 567
 * @date: 2022/2/26
 * @version: 1.0.0
 */
public class WechatAuthCheckConfig {

    private String appId;

    private String accessToken;

    private String expiresIn;

    private String timestamp;

    private String nonceStr;

    private String signature;

    private List<String> jsApiList;
}
