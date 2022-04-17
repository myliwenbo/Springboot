package vip.xjdai.springbootshushionetest.enums;

import pro.shushi.pamirs.meta.common.enmu.BaseEnum;

public class QtsCodeCenterMethodEnum extends BaseEnum<QtsCodeCenterMethodEnum,String> {

    public final static QtsCodeCenterMethodEnum FACTORY_ORDER = create("FACTORY_ORDER","FACTORY_ORDER","出厂单信息+出货单信息","出厂单信息+出货单信息");
    public final static QtsCodeCenterMethodEnum CODE_SKU_RELATION = create("CODE_SKU_RELATION","CODE_SKU_RELATION","码生产记录-镭雕记录","码生产记录-镭雕记录");
    public final static QtsCodeCenterMethodEnum SCAN_INFO = create("SCAN_INFO","SCAN_INFO","C端用户扫码记录","C端用户扫码记录");
    public final static QtsCodeCenterMethodEnum CODE_RELATION = create("CODE_RELATION","CODE_RELATION","码关系（绑定，解绑，替换）","码关系（绑定，解绑，替换）");
    //计算包装数量用。
    public final static QtsCodeCenterMethodEnum CODE_CHAIN_TREE = create("CODE_RELATION_CHAIN","CODE_RELATION_CHAIN","码链路","码链路");



}
