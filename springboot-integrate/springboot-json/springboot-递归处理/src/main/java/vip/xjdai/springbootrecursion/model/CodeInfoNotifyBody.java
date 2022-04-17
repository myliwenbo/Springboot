package vip.xjdai.springbootrecursion.model;

import pro.shushi.pamirs.meta.annotation.Field;
import pro.shushi.pamirs.meta.annotation.Model;
import pro.shushi.pamirs.meta.base.IdModel;
import pro.shushi.pamirs.meta.enmu.ModelTypeEnum;

@Model.model(CodeInfoNotifyBody.MODEL_MODEL)
@Model(displayName = "消息模型")
@Model.Advanced(type = ModelTypeEnum.STORE)
public class CodeInfoNotifyBody extends IdModel {

    public static final String MODEL_MODEL = "qts.eip.codecenter.CodeInfoNotifyBody";
    public static final String TOPIC = "relx_code_opt_business_sync_topic";
    public static final String TAG = "opt_business_queue";

    /**
     * 操作业务号（与数据绑定的业务号）
     **/
    @Field(displayName = "操作业务号")
    private String businessNo;

    /**
     * 操作类型，insert,update,delete 因数据延迟，update 可能需要insert操作
     **/
    @Field(displayName = "操作类型")
    private String operate;

    /**
     * 方法类型 FACTORY_ORDER,CODE_SKU_RELATION,SCAN_INFO,CODE_RELATION,FACTORY_ORDER_DETAIL
     **/
    @Field(displayName = "方法类型")
    private String methodEnum;

}