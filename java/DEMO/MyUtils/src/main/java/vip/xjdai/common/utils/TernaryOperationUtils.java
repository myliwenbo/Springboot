package vip.xjdai.common.utils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 三元运算，保持代码的客观性，后续需要自己添加。
 *
 * @author lwb
 */
public class TernaryOperationUtils {

    private TernaryOperationUtils() {

    }

    private static Boolean judge(Object object) {
        return object == null;
    }

    /**
     * 判断 BigDecimal
     * <pre>
     *  true:  返回一个 BigDecimal(0)
     *  false: 返回本身
     * </pre>
     *
     * @param big
     * @return
     */
    public static BigDecimal isNull(BigDecimal big) {
        BigDecimal check = judge(big) ? new BigDecimal(0) : big;
        return check;

    }

    /**
     * 判断 BigDecimal，转为String
     * <pre>
     *  true:  返回一个 BigDecimal(0).toString
     *  false: 返回本身.toString
     * </pre>
     *
     * @param big
     * @return
     */
    public static String isNullToString(BigDecimal big) {
        BigDecimal check = isNull(big);
        return check.toString();
    }

    /**
     * 判断 BigDecimal，并且转为int
     * <pre>
     *  true:  返回一个 BigDecimal(0).toString
     *  false: 返回本身.toString
     * </pre>
     *
     * @param big
     * @return
     */
    public static Integer isNullToInteger(BigDecimal big) {
        BigDecimal check = isNull(big);
        return check.intValue();
    }

    public static Date dateIsNull(Date time) {
        Date timeIsNull = judge(time) ? null : time;
        return timeIsNull;
    }

    public static Integer isNull(Integer big) {
        Integer check = judge(big) ? new Integer(0) : big;
        return check;
    }

    public static String isNullToString(Integer big) {
        Integer check = judge(big) ? new Integer(0) : big;
        return check.toString();
    }

    public static String isNullToString(Long big) {
        Long check = judge(big) ? new Long(0) : big;
        return check.toString();
    }

    public static String isNullToString(Short big) {
        Short check = judge(big) ? new Short((short) 0) : big;
        return check.toString();
    }

    public static String isNullToString(String big) {
        String check = judge(big) ? "" : big;
        return check;
    }

}
