package vip.xjdai.springbootshushionetest.enums;

import pro.shushi.pamirs.meta.common.enmu.ExpBaseEnum;
import pro.shushi.pamirs.meta.common.enmu.IEnum;

public enum QtsEipExpEnumerate implements ExpBaseEnum, IEnum<Integer> {
    //通用的
    BIZ_ERROR(ERROR_TYPE.BIZ_ERROR, 50000000, "请注意"),
    EIP_ERROR(ERROR_TYPE.BIZ_ERROR, 50001000, "同步失败"),
    SERVICE_ERROR(ERROR_TYPE.BIZ_ERROR, 50001001, "eip服务异常"),
    //码中心
    CODE_CENTER_CONFIG_ERRR(ERROR_TYPE.REMOTE_ERROR, 50050100, "码中心配置异常"),
    CODE_CENTER_PULL_OPREATE_ERRR(ERROR_TYPE.REMOTE_ERROR, 50050101, "码中心获取接口拉取失败"),
    CODE_CENTER_PULL_DATE_ERRR(ERROR_TYPE.REMOTE_ERROR, 50050102, "码中心接口时间转化失败"),
    CODE_CENTER_CAPTCHA_NULL_ERRR(ERROR_TYPE.REMOTE_ERROR, 50050103, "未查询到此防伪码"),
    CODE_CENTER_CODE_SKU_RELATION_PULL_ERRR(ERROR_TYPE.BIZ_ERROR, 50050104, "新增码生产关系失败"),
    CODE_CENTER_CODE_RELATION_PULL_ERRR(ERROR_TYPE.BIZ_ERROR, 50050105, "新增码关系异常"),
    CODE_CENTER_FACTORY_ORDER_PULL_ERRR(ERROR_TYPE.BIZ_ERROR, 50050106, "新增出厂单失败"),
    CODE_CENTER_SCAN_INFO_PULL_ERRR(ERROR_TYPE.BIZ_ERROR, 50050107, "新增扫码记录详情失败"),
    CODE_CENTER_SYNC_ERRR(ERROR_TYPE.BIZ_ERROR, 50050108, "码中心增量同步对象传入为空"),
    CODE_CENTER_UPDATE_SCANID_ERRR(ERROR_TYPE.BIZ_ERROR, 50050109, "码中心增量拉取游标更新失败"),
    CODE_CHAIN_TREE_ERRR(ERROR_TYPE.BIZ_ERROR, 50050110, "码链路异常，匹配失败"),


    //擎雷错误枚举
    CODE_QINGLEI_IN_BOUND_ERROR(ERROR_TYPE.BIZ_ERROR, 50050501, "入库单不能为空"),
    CODE_QINGLEI_IN_BOUND_DETAIL_ERROR(ERROR_TYPE.BIZ_ERROR, 50050502, "入库单明细不能为空"),
    CODE_QINGLEI_ORDER_CODE_ERROR(ERROR_TYPE.BIZ_ERROR, 50050503, "订单编号不能为空"),
    CODE_QINGLEI_DEALER_CODE_ERROR(ERROR_TYPE.BIZ_ERROR, 50050504, "经销商编号不能为空"),
    CODE_QINGLEI_SERIAL_CODE_ERROR(ERROR_TYPE.BIZ_ERROR, 50050505, "防伪码（序列号）不能为空"),
    CODE_QINGLEI_SERIAL_CODE_LIST_ERROR(ERROR_TYPE.BIZ_ERROR, 50050506, "序列号集合不能为空"),
    CODE_QINGLEI_OUT_BOUND_ORDER_CODE_ERROR(ERROR_TYPE.BIZ_ERROR, 50050507, "出库单号不能为空"),
    CODE_QINGLEI_OUT_BOUND_ORDER_CODE_LIST(ERROR_TYPE.BIZ_ERROR, 50050508, "出库订单集合为空"),
    CODE_QINGLEI_OUT_BOUND_ORDER_DETAIL_LIST(ERROR_TYPE.BIZ_ERROR, 50050509, "出库订单详情为空"),
    CODE_QINGLEI_CODE_ERROR(ERROR_TYPE.BIZ_ERROR, 50050510, "烟弹二维码的c参数、盒标序列号、箱标序列号为空"),
    CODE_QINGLEI_CODE_CODE_ERROR(ERROR_TYPE.BIZ_ERROR, 50050511, "箱标、盒标、中箱标序列号以及烟弹14位英数防伪码为空"),

    //擎雷配置中心错误
    CODE_QINGLEI_WUXIN_CONFIG_ERRR(ERROR_TYPE.REMOTE_ERROR, 500550, "擎雷雾芯配置异常"),
    CODE_QINGLEI_RELX_CONFIG_ERRR(ERROR_TYPE.REMOTE_ERROR, 500551, "擎雷RELX配置异常"),
    CODE_QINGLEI_QUERY_CONFIG_ERRR(ERROR_TYPE.REMOTE_ERROR, 500552, "擎雷QUERY配置异常"),
    ;

    private ERROR_TYPE type;
    private int code;
    private String msg;

    QtsEipExpEnumerate(ERROR_TYPE type, int code, String msg) {
        this.type = type;
        this.code = code;
        this.msg = msg;
    }

    public ERROR_TYPE getType() {
        return type;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

