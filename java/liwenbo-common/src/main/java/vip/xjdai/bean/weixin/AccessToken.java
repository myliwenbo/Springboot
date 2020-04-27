package vip.xjdai.bean.weixin;

import lombok.Data;

@Data
public class AccessToken {

    // 错误code
    private String errcode;

    // 错误msg
    private String errmsg;

    // 获取到的凭证
    private String access_token;

    // 凭证有效时间，单位：秒
    private int    expires_in;

}