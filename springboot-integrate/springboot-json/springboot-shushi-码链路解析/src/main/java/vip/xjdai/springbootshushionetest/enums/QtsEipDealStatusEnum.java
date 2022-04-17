package vip.xjdai.springbootshushionetest.enums;

import pro.shushi.pamirs.meta.common.enmu.BaseEnum;

public class QtsEipDealStatusEnum extends BaseEnum<QtsEipDealStatusEnum, String> {

    public static final String DICTIONARY ="qts.eip.QtsEipDealStatusEnum";

    public final static QtsEipDealStatusEnum DEALOK = create("DEALOK","DEALOK","处理完","处理完");
    public final static QtsEipDealStatusEnum NOTDEAL = create("NOTDEAL","NOTDEAL","未处理","未处理");
    public final static QtsEipDealStatusEnum DEALERR = create("DEALERR","DEALERR","处理异常","处理异常");
}
