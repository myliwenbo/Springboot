package cn.zingfin.finance.bean;

public enum SystemErrorCodeEnum implements ErrorCode {
    SYSTEM_ERROR(0, "系统错误"),
    PARAM_FAIL(1, "参数错误"),
    FAIL(2, "请求失败"),
    TIME_OUT(3, "调用超时"),
    ORDER_BY_COLUMN_CANNOT_NULL(3001, "排序列不能为空");

    private int code;
    private String message;

    private SystemErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
