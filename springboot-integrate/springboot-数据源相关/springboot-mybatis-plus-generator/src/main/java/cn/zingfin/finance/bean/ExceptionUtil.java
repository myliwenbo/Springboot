package cn.zingfin.finance.bean;


public class ExceptionUtil {
    public ExceptionUtil() {
    }

    public static BizException buildFailException(String message) {
        return new BizException(SystemErrorCodeEnum.FAIL, message);
    }

    public static BizException buildFailException(ErrorCode code, String message) {
        return new BizException(code, message);
    }

    public static BizException buildFailException(int code, String message) {
        return new BizException(code, message);
    }

    public static BizException buildFailException(ErrorCode code) {
        return new BizException(code);
    }
}
