package vip.xjdai.common.exception;

public class BizJsonProcessingException extends BizException {

    private final static String ERROR_MESSAGE = "JSON转换错误";

    private String parameter;

    /**
     *
     */
    private static final long serialVersionUID = 1348565284000752832L;

    /**
     * JSON转换异常的错误
     *
     * @param parameter 转换的错误的数据
     */
    public BizJsonProcessingException(String parameter) {
        super(ERROR_MESSAGE);
        this.parameter = parameter;

    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

}
