package vip.xjdai.springbootshushionetest.enums;

import pro.shushi.pamirs.meta.common.enmu.BaseEnum;

public class QtsEipCodeCenterPullStatusEnum extends BaseEnum<QtsEipCodeCenterPullStatusEnum, String> {

    public static final String DICTIONARY = "qts.eip.QtsEipCodeCenterPullStatusEnum";

    public final static QtsEipCodeCenterPullStatusEnum NOTPULLED = create("NOTPULLED", "NOTPULLED", "未拉取", "未拉取");
    public final static QtsEipCodeCenterPullStatusEnum PULLING = create("PULLING", "PULLING", "拉取中", "拉取中");
    public final static QtsEipCodeCenterPullStatusEnum PULLED = create("PULLED", "PULLED", "拉取完", "拉取完");
}
