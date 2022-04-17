package vip.xjdai.springbootshushionetest.model;

import pro.shushi.pamirs.meta.annotation.Field;
import pro.shushi.pamirs.meta.base.common.CodeModel;
import pro.shushi.pamirs.meta.common.constants.CharacterConstants;
import pro.shushi.pamirs.resource.model.OutResourceRelation;

import java.util.List;

public class ItemSeries extends CodeModel {

    public static final String MODEL_MODEL = "himalaya.item.ItemSeries";

    @Field.String
    @Field(displayName = "系列编码",unique = true)
    private String code;

    @Field.String
    @Field(displayName = "系列名称", required = true, unique = true, translate = true)
    private String name;

    @Field.Text
    @Field(displayName = "备注")
    private String remark;

}
