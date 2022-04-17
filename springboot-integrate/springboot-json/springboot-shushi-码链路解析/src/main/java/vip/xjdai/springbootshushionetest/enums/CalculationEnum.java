package vip.xjdai.springbootshushionetest.enums;

import pro.shushi.pamirs.meta.common.enmu.BaseEnum;

/**
 * 主要用于下一层的计算
 */
public class CalculationEnum extends BaseEnum<CalculationEnum, Integer> {
    public static final String DICTIONARY = "qts.tracecode.CalculationEnum";
    public final static CalculationEnum IS_ERROR = create("IS_ERROR", 0, "异常数据", "异常数据");
    public final static CalculationEnum UP_IS_INCONSISTENT = create("UP_IS_INCONSISTENT", 1, "解析异常", "解析异常");
    public final static CalculationEnum SPECIAL_PRODUCTS = create("SPECIAL_PRODUCTS", 2, "特殊产品", "特殊产品");

}
