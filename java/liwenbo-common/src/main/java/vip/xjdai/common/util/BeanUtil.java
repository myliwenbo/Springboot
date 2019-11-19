package vip.xjdai.common.util;

public final class BeanUtil {
    public static boolean isNull(final Object object)
    {
        return null == object;
    }

    public static boolean nonNull(final Object object)
    {
        return null != object;
    }

    public static Object requireNonNull(final Object object, final String errorMessage)
    {
        if (null == object) {
            throw new NullPointerException(errorMessage);
        }
        return object;
    }

    public static String requireNonString(final String data, final String errorMessage)
    {
        if (null == data || "".equals(data)) {
            throw new NullPointerException(errorMessage);
        }
        return data;
    }
}