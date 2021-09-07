package vip.xjdai.common.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 通用异常
 *
 * @author lwb
 */

public class BizException extends RuntimeException {

    /**
     * SID
     */
    protected static final long serialVersionUID = 1151709043840098673L;
    /**
     * 错误的CODE
     */
    protected String errorCode;
    /**
     * 错误的信息
     */
    protected String errorMsg;
    /**
     * 状态码
     * <pre>
     *      如果是 1 代表是成功
     *      如果是 0 代表是失败
     *   </pre>
     */
    protected int status;

    public BizException() {
    }

    /**
     * 创建一个通用异常,并且附带错误信息系
     *
     * @param errorMsg 错误信息
     * @return
     */
    public static BizException newBizException(String errorMsg) {
        return new BizException(errorMsg);
    }

    protected BizException(String errorMsg) {
        this(false, errorMsg);

    }

    public BizException(final BaseResultCode resultCode) {
        this.errorCode = resultCode.getCode();
        this.errorMsg = resultCode.getMsg();
    }

    /**
     * @param success
     * @param errorMsg
     */
    public BizException(boolean success, String errorMsg) {
        this.status = success ? 1 : 0;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}