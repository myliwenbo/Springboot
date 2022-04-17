package vip.xjdai.springbootshushionetest.enums;

import pro.shushi.pamirs.meta.common.enmu.BaseEnum;

public class
CodeTypeEnum extends BaseEnum<CodeTypeEnum, Integer> {

    public static final String DICTIONARY = "qts.tracecode.CodeTypeEnum";

    public final static CodeTypeEnum CARTRIDGE = create("CARTRIDGE", 1, "烟弹", "烟弹");
    public final static CodeTypeEnum SMALL = create("SMALL", 2, "小盒(烟弹)", "小盒(烟弹)");
    public final static CodeTypeEnum ROD = create("ROD", 3, "小盒(烟杆)", "小盒(烟杆)");
    public final static CodeTypeEnum MID = create("MID", 4, "中箱", "中箱");
    public final static CodeTypeEnum BIG = create("BIG", 5, "大箱", "大箱");

}