package vip.xjdai.common.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import vip.xjdai.common.exception.BaseResultCode;

/**
 * 用于service的统一反参
 *
 * @param <T>
 * @author lwb
 */
public class BaseResult<T> implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private boolean isSuccess;
    private String errorCode;
    private String errorMsg;
    private T data;

    public BaseResult() {
        this.setSuccess(true);
    }

    public BaseResult(final boolean isSuccess, final T data) {
        this.isSuccess = isSuccess;
        this.data = data;
    }

    public BaseResult(final T data) {
        this.setSuccess(true);
        this.data = data;
    }

    public BaseResult(final BaseResultCode code) {
        this.setSuccess(false);
        this.errorCode = code.getCode();
        this.errorMsg = code.getMsg();
    }

    public BaseResult(final String errorCode, final String errorMsg) {
        this.setSuccess(false);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(final boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(final String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object) this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}