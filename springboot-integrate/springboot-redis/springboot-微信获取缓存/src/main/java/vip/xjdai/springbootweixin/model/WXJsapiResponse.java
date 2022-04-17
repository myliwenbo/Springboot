package vip.xjdai.springbootweixin.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 参考文档：
 */
@Data
public class WXJsapiResponse extends WXAccessToken {
    /**
     * ticket
     */
    private String ticket;
    /**
     * 过期时间
     */
    @JSONField(name = "expires_in")
    private Long expiresIn;
}
