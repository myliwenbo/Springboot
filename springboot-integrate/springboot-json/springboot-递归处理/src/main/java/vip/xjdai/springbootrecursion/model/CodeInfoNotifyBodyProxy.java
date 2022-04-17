package vip.xjdai.springbootrecursion.model;

import pro.shushi.pamirs.meta.annotation.Field;
import pro.shushi.pamirs.meta.annotation.Fun;
import pro.shushi.pamirs.meta.annotation.Function;
import pro.shushi.pamirs.meta.annotation.Model;
import pro.shushi.pamirs.meta.enmu.ModelTypeEnum;

@Model.model(CodeInfoNotifyBodyProxy.MODEL_MODEL)
@Model.Advanced(type = ModelTypeEnum.PROXY)
@Model(displayName = "消息模型的代理模型", summary = "消息模型的代理模型")
public class CodeInfoNotifyBodyProxy extends CodeInfoNotifyBody {
    public static final String MODEL_MODEL = "qts.eip.codecenter.CodeInfoNotifyBodyProxy";

    @Field(displayName = "异常拉取")
    private Boolean errorPull;


}
