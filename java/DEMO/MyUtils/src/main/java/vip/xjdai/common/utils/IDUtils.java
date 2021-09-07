package vip.xjdai.common.utils;

import java.util.UUID;

public class IDUtils {

    private final static String SYMBOL = "-";

    private IDUtils() {

    }

    public static String getId() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replace(SYMBOL, "");
    }

}
