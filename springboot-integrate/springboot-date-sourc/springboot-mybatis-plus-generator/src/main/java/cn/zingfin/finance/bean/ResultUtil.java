package cn.zingfin.finance.bean;


public class ResultUtil {
    public ResultUtil() {
    }

    public static boolean isResultSuccess(ResultMsg result) {
        return null != result && result.isSuccess();
    }

    public static boolean isResultNotSuccess(ResultMsg result) {
        return !isResultSuccess(result);
    }

    public static boolean isResultNotNull(ResultMsg result) {
        return isResultSuccess(result) && null != result.getResult();
    }

    public static boolean isResultNull(ResultMsg result) {
        return !isResultSuccess(result) || null == result.getResult();
    }

    public static ResultMsg defaultResult() {
        return ResultMsg.builder().build();
    }

    public static ResultMsg successResult(Object result) {
        ResultMsg resultMsg = defaultResult();
        resultMsg.setResult(result);
        return resultMsg;
    }

}
