package vip.xjdai.springbootshushionetest.enums;

import pro.shushi.pamirs.meta.common.enmu.BaseEnum;

/**
 * 数据深度
 * {@link  vip.xjdai.springbootshushionetest.enums.CodeTypeEnum }
 */
public class CodeMarkTypeEnum extends BaseEnum<CodeMarkTypeEnum, Integer> {

    public static final String DICTIONARY = "qts.tracecode.CodeMarkTypeEnum";

    // 这里的Value 实际是需要根据 其他枚举值来定，这样那边变，这边也变..
    public final static CodeMarkTypeEnum BIG_MID_ROD = create("BIG_MID_ROD", 345, " 大-中-小烟杆", " 大-中-小烟杆");
    public final static CodeMarkTypeEnum BIG_MID_SMALL_CARTRIDGE = create("BIG_MID_SMALL_CARTRIDGE", 1245, "大-中-小烟盒-烟弹", "大-中-小烟盒-烟弹");
    public final static CodeMarkTypeEnum BIG_MID_CARTRIDGE = create("BIG_MID_CARTRIDGE", 145, "大-中-烟弹", "大-中-烟弹");
    public final static CodeMarkTypeEnum BIG_MID = create("BIG_MID", 45, "大-中", "大-中");
    public final static CodeMarkTypeEnum BIG_SMALL_CARTRIDGE = create("BIG_SMALL_CARTRIDGE", 125, "大-小烟弹-烟弹", "大-小烟弹-烟弹");
    public final static CodeMarkTypeEnum BIG_ROD = create("BIG_ROD", 35, "大-小烟感", "大-小烟感");
    public final static CodeMarkTypeEnum ROD = create("ROD", 3, "小烟感", "小烟感");
    public final static CodeMarkTypeEnum CARTRIDGE = create("CARTRIDGE", 12, "小烟弹-烟弹", "小烟弹-烟弹");

    /**
     * 先兼容老的内容，等后续会进行删除，因为以前解析是按照这个来的，有点问题..不够全
     * 2022年3月12日20:38:03
     */
    public final static CodeMarkTypeEnum BIG_MEDIUM_SMALL = create("BIG_MEDIUM_SMALL", 1, "大-中-小", "大-中-小");
    public final static CodeMarkTypeEnum BIG_MEDIUM = create("BIG_MEDIUM", 2, "大-中", "大-中");
    public final static CodeMarkTypeEnum BIG_SMALL = create("BIG_SMALL", 3, "大-小", "大-小");
    public final static CodeMarkTypeEnum SMALL = create("SMALL", 4, "小", "小");
}