package vip.xjdai.springbootshushionetest.model;

import lombok.Data;
import pro.shushi.pamirs.meta.annotation.Field;
import pro.shushi.pamirs.meta.enmu.NullableBoolEnum;
import vip.xjdai.springbootshushionetest.enums.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class QtsCodeProductInfo {

    @Field(displayName = "序列号", required = true)
    private String serialNo;

    @Field(displayName = "防伪码", store = NullableBoolEnum.FALSE)
    private String captcha;

    @Field(displayName = "系列编码")
    private String seriesCode;

    @Field(displayName = "系列名称")
    private String seriesName;

    @Field(displayName = "产品名称")
    private String bindSkuName;

    @Field(displayName = "英文名称")
    private String enName;

    @Field(displayName = "产品编码")
    private String bindSkuCode;

    @Field(displayName = "69码")
    private String barCode;

    @Field(displayName = "产品生产日期")
    private Timestamp produceTime;

    @Field(displayName = "有效期至")
    private Timestamp expiration;

    // 拉数据时计算的数量
    @Field(displayName = "首次包装数量")
    private BigDecimal firstQuantity;

    //第一次时和首次数量一致，后面会更新。
    @Field(displayName = "包装数量")
    private BigDecimal quantity;

    @Field(displayName = "批次号")
    private String batchNo;

    /**
     * false为老码 true为新码
     **/
    @Field(displayName = "新老码判断字段")
    private Boolean isNewCode;

    /**
     * 0为解析成功 1为解析异常，允许扫瞄成功、入库，不允许销售出库，只允许其他出库 2为解析异常，产品信息缺失，扫描入库、出库、退货时，扫描失败
     **/
    @Field(displayName = "包装关系解析状态")
    private CodeAnalysisStatusEnum analysisStatus;

    @Field(displayName = "解析失败原因")
    private String analysisErrReason;

    @Field(displayName = "码创建人")
    private String createName;

    @Field(displayName = "码更新人")
    private String writeName;

    @Field(displayName = "外部创建时间")
    private Timestamp outCreateDate;

    @Field(displayName = "创建时间")
    private Timestamp createDate;

    @Field(displayName = "更新时间")
    private Timestamp writeDate;

    @Field.Enum
    @Field(displayName = "码类型", required = true, summary = "作为基类给每一个继承模型增加一个码类型字段")
    private CodeTypeEnum codeType;

    @Field(displayName = "系统创建人")
    private Long createUid;

    @Field(displayName = "系统更新人")
    private Long writeUid;

    /**
     * 拉数据的业务号，存起来。
     */
    @Field(displayName = "业务号")
    private String businessNo;

    /**
     * 0=上层补齐
     * 1=出厂自带
     **/
    @Field(displayName = "补齐69码状态")
    private RepairedBarcodeStatusEnum repairedBarcodeStatus;

    /**
     * 0=不存在
     * 1=存在
     **/
    @Field(displayName = "是否存在规格表中")
    private ExistInSpecEnum existInSpec;

    /**
     *
     **/
    @Field(displayName = "包装结构")
    private CodeMarkTypeEnum packagingStructure;
}
