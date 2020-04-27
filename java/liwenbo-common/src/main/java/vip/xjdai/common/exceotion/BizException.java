package vip.xjdai.common.exceotion;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import vip.xjdai.common.domain.BaseResultCode;

/**
 * 自定义异常
 * @author lwb
 *
 */
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 5767742749923265235L;
    private String            errorCode;
    private String            errorMsg;

    public BizException() {
    }

    public BizException(final BaseResultCode resultCode) {
        this.errorCode = resultCode.getCode();
        this.errorMsg = resultCode.getMsg();
    }

    public BizException(final String errorCode, final String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode()
    {
        return this.errorCode;
    }

    public void setErrorCode(final String errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMsg()
    {
        return this.errorMsg;
    }

    public void setErrorMsg(final String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString((Object) this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}