package vip.xjdai.web;

/**
 *  通用异常处理
 * @author lwb
 *
 */
public class BizException extends RuntimeException {

    /**
     * 
     */
    protected static final long serialVersionUID = 1151709043840098673L;
    /**
     * 错误的CODE
     */
    protected String            errorCode;
    /**
     * 错误的信息
     */
    protected String            errorMsg;
    /**
     * 状态码
     */
    protected int               status;

    public BizException() {
    }

    /**
     * 创建一个通用异常
     * @return
     */
    public static BizException newBizException() {
        return new BizException();
    }

    /**
     * 创建一个通用异常,并且附带错误信息系
     * @param errorMsg 错误信息
     * @return
     */
    public static BizException newBizException(String errorMsg) {
        return new BizException(errorMsg);
    }

    public BizException(String errorMsg) {
        this.status = 0;
        this.errorCode = "4004";
        this.errorMsg = errorMsg;
    }

    public BizException(boolean success, String errorMsg) {
        this.status = success ? 1 : 0;
        this.errorMsg = errorMsg;
    }

    public BizException(String errorMsg, String errorCode) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
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

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}