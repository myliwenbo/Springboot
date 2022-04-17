package vip.xjdai.springbootweixin.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class WXAccessToken extends WXBaseResponse {
    /**
     * 获取到的凭证
     */
    @JSONField(name = "access_token")
    private String accessToken;
    /**
     * 凭证有效时间，单位：秒
     */
    @JSONField(name = "expires_in")
    private Long expiresIn;

}
