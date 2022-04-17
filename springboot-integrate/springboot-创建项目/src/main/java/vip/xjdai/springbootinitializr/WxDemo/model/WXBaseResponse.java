package vip.xjdai.springbootinitializr.WxDemo.model;

import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

@Data
public class WXBaseResponse {
    /**
     * 错误Code
     */
    private Integer errcode;
    /**
     * 错误信息
     */
    private String errmsg;

    public Boolean isSuccess() {
        return this.getErrcode() == null || "0".equals(this.getErrcode()+"") || ObjectUtils.isEmpty(this.getErrcode());

    }

}
