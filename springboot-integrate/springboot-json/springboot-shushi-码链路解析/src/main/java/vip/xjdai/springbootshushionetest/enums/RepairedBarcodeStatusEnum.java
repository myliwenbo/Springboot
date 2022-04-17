package vip.xjdai.springbootshushionetest.enums;

import pro.shushi.pamirs.meta.common.enmu.BaseEnum;

public class RepairedBarcodeStatusEnum extends BaseEnum<RepairedBarcodeStatusEnum,Integer> {
    public static final String DICTIONARY ="qts.tracecode.RepairedBarcodeStatusEnum";

    public final static RepairedBarcodeStatusEnum NEED_REPAIRE = create("NEED_REPAIRE",0,"上层补齐","上层补齐");
    public final static RepairedBarcodeStatusEnum NOT_NEED_REPAIRE = create("NOT_NEED_REPAIRE",1,"出厂自带","出厂自带");
}
