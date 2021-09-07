package vip.xjdai.common.utils;

public class IntegerUtils {

    public static Boolean isNull(Integer value) {
        if (value != null && value != 0) {
            return true;
        }
        return false;
    }
}
