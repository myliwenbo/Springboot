package vip.xjdai.common.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * WEB开发统一出参
 *
 * @author lwb
 */
public class ResponseBean implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 6707847582477794117L;
    /**
     * 返回给前端的状态
     */
    private int status;
    /**
     * 返回给前端的错误信息
     */
    private String errorMsg;
    /**
     * 实际的出参参数
     */
    private Object data;

    public ResponseBean() {
        this.status = 1;
    }

    public ResponseBean(boolean success) {
        this.status = success ? 1 : 0;
    }

    public ResponseBean(Object data) {
        this.status = 1;
        this.data = data;
    }

    public ResponseBean(boolean success, String errorMsg) {
        this.status = success ? 1 : 0;
        this.errorMsg = errorMsg;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}