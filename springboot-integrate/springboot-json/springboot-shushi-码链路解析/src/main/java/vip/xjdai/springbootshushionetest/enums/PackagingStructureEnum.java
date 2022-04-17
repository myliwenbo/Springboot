package vip.xjdai.springbootshushionetest.enums;

import pro.shushi.pamirs.meta.common.enmu.BaseEnum;

public class PackagingStructureEnum extends BaseEnum<PackagingStructureEnum, Integer> {
    public static final String DICTIONARY = "qts.tracecode.PackagingStructureEnum";

    public final static PackagingStructureEnum BIG_MEDIUM_SMALL = create("BIG_MEDIUM_SMALL", 1, "大-中-小", "大-中-小");
    public final static PackagingStructureEnum BIG_MEDIUM = create("BIG_MEDIUM", 2, "大-中", "大-中");
    public final static PackagingStructureEnum BIG_SMALL = create("BIG_SMALL", 3, "大-小", "大-小");
    public final static PackagingStructureEnum SMALL = create("SMALL", 4, "小", "小");
}
