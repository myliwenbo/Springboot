package vip.xjdai.springbootshushionetest.model;

import lombok.Data;
import pro.shushi.pamirs.meta.annotation.Field;
import pro.shushi.pamirs.meta.base.IdModel;
import vip.xjdai.springbootshushionetest.enums.QtsEipCodeCenterPullStatusEnum;
import vip.xjdai.springbootshushionetest.enums.QtsEipDealStatusEnum;

@Data
public class QtsCodeScanIdModel extends IdModel {
    public static final String MODEL_MODEL = "qts.eip.QtsCodeScanIdModel";

    /**
     * 操作业务号（与数据绑定的业务号）
     **/
    @Field.String
    @Field(displayName = "操作业务号")
    private String businessNo;

    /**
     * 操作类型，insert,update,delete 因数据延迟，update 可能需要insert操作
     **/
    @Field.String
    @Field(displayName = "操作类型")
    private String operate;

    @Field.Integer
    @Field(displayName = "游标Id", summary = "保存最近一次操作游标id", defaultValue = "0")
    private Long scanId;


    // add at 2021-12
    /**
     * 方法类型 FACTORY_ORDER,CODE_SKU_RELATION,SCAN_INFO,CODE_RELATION,FACTORY_ORDER_DETAIL
     **/
    @Field.String
    @Field(displayName = "方法类型")
    private String methodEnum;

    @Field.Enum
    @Field.Advanced(columnDefinition = "varchar(32)")
    @Field(displayName = "拉取状态", defaultValue = "NOTPULLED")
    private QtsEipCodeCenterPullStatusEnum pullStatusEnum;

    // 每次叠加计算。
    @Field.Integer
    @Field(displayName = "单个业务号返回的条数", defaultValue = "0")
    private Long size;

    // 备用
    @Field.Integer
    @Field(displayName = "已插入的条数", defaultValue = "0", invisible = true)
    private Long insertSize;

    // 备用。
    @Field.Integer
    @Field(displayName = "已更新的条数", defaultValue = "0", invisible = true)
    private Long updateSize;

    @Field.Enum
    @Field.Advanced(columnDefinition = "varchar(32)")
    @Field(displayName = "处理状态", defaultValue = "NOTDEAL")
    private QtsEipDealStatusEnum dealStatusEnum;

    @Field.Text
    @Field(displayName = "处理异常信息")
    private String dealException;

    /**
     * 主要存码链路数据。  其实eip_log里面已经有了。其他的可以在里面查。
     */
    @Field.Text
    @Field.Advanced(columnDefinition = "longtext")
    @Field(displayName = "返回数据")
    private String responseData;

    @Field.Integer
    @Field(displayName = "请求耗时/毫秒")
    private Long requestTime;

    @Field.Integer
    @Field(displayName = "处理耗时/毫秒")
    private Long dealTime;
}