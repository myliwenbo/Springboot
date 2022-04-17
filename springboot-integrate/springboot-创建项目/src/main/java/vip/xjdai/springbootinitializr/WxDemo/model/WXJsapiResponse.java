package vip.xjdai.springbootinitializr.WxDemo.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 参考文档：
 */
@Data
public class WXJsapiResponse extends WXBaseResponse {
    /**
     * ticket
     */
    private String ticket;
    /**
     * 过期时间
     */
    @JSONField(name = "expires_in")
    private long expiresIn;
}
