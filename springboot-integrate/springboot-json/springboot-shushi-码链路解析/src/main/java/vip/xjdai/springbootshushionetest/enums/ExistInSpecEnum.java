package vip.xjdai.springbootshushionetest.enums;

import pro.shushi.pamirs.meta.common.enmu.BaseEnum;

public class ExistInSpecEnum extends BaseEnum<ExistInSpecEnum,Integer> {
    public static final String DICTIONARY ="qts.tracecode.ExistInSpecEnum";

    public final static ExistInSpecEnum NOT_EXIST = create("NOT_EXIST",0,"不存在","不存在");
    public final static ExistInSpecEnum EXIST = create("EXIST",1,"存在","存在");
}
