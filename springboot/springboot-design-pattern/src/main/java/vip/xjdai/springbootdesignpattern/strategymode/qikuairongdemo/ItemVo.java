package vip.xjdai.springbootdesignpattern.strategymode.qikuairongdemo;

import lombok.Data;

import java.util.List;

/**
 * <p>
 * 商品表
 * </p>
 *
 * //author quyl
 * //since 2020-03-05
 */
@Data
public class ItemVo  {
    private Long id;


    private String ext;

    //ApiModelProperty(value = "商品名称")
    private String name;

    //ApiModelProperty(value = "申请流程模板id")
    private Long applyTemplateId;

    //ApiModelProperty(value = "创建者id")
    private Long createId;

    //ApiModelProperty(value = "额度上限")
    private Long limitUpper;

    //ApiModelProperty(value = "额度下限")
    private Long limitLower;

    //ApiModelProperty(value = "贷款利率")
    private Float rate;

    //ApiModelProperty(value = "贷款利率上限")
    private Float rateUpper;

    //ApiModelProperty(value = "贷款期限上限")
    private Long timeUpper;

    //ApiModelProperty(value = "贷款期限下限")
    private Integer timeLower;

    //ApiModelProperty(value = "还款方式")
    private Integer refundType;

    //ApiModelProperty(value = "担保方式")
    private Integer guaranteeType;

    //ApiModelProperty(value = "适用范围")
    private String rangeType;

    //ApiModelProperty(value = "组织id")
    private Long orgId;

    //ApiModelProperty(value = "热门商品 1是 0不是")
    private Integer hot;

    //ApiModelProperty(value = "分类ID")
    private Long category;

    //ApiModelProperty(value = "用途（使用二进制存储~~）")
    private Integer tags;

    //ApiModelProperty(value = "成功率 （1-10代表1-5星）")
    private Integer successRate;

    //ApiModelProperty(value = "是否上架 1上架 0不上架")
    private Integer isShelf;

    //ApiModelProperty(value = "图片的URL")
    private String itemUrl;

    //ApiModelProperty(value = "商品模板ID")
    private Long itemTemplateId;

    //ApiModelProperty(value = "成功数量")
    private Integer successNum;

    //ApiModelProperty(value = "商品保存步骤")
    private String itemSaveNext;

    //ApiModelProperty(value = "修改日期")
    private Long opTime;
    //ApiModelProperty(value = "创建日期")
    private Long createTime;


    //ApiModelProperty(value = "标签通过String拼接返回")
    private String tagsValue;
    //ApiModelProperty(value = "担保方式通过String拼接")
    private String guaranteeTypeValue;
    //ApiModelProperty(value = "还款方式通过String拼接返回")
    private String refundTypeValue;

    //ApiModelProperty("组织logo")
    private String logo;

    //ApiModelProperty(value = "组织名称")
    private String orgName;
    //ApiModelProperty(value = "是否是外部商品")
    protected Byte type;

    //ApiModelProperty("1：查询所有2：查询本机构3:无接触金融商品")
    private String selectType;

    //ApiModelProperty(value = "用途（使用二进制存储~~）")
    private Integer useCase;

    //ApiModelProperty(value = "二维码内容")
    private Integer erCode;


}
