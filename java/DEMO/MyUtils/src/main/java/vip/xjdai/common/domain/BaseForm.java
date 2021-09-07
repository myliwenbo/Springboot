package vip.xjdai.common.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * WEB开发统一入参
 *
 * @param <T> 实际的参数
 * @author lwb
 */
public class BaseForm<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2732767648508734562L;

    /**
     * 实际入参
     */
    private T data;
    /**
     * 实际的token，根据token做权限校验
     */
    private String token;
    /**
     * 时间戳
     */
    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}