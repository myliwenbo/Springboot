package vip.xjdai.strategymode.qikuairongdemo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


@Data
public class Item {

    private static final long serialVersionUID = 1L;

    private String ext;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 申请流程模板id
     */
    private Long applyTemplateId;

    /**
     * 创建者id
     */
    private Long createId;

    /**
     * 额度上限
     */
    private Long limitUpper;

    /**
     * 额度下限
     */
    private Long limitLower;

    /**
     * 贷款利率
     */
    private Integer rate;

    /**
     * 贷款利率上限
     */
    private Integer rateUpper;

    /**
     * 贷款期限上限
     */
    private Long timeUpper;

    /**
     * 贷款期限下限
     */
    private Integer timeLower;

    /**
     * 还款方式
     */
    private Integer refundType;

    /**
     * 担保方式
     */
    private Integer guaranteeType;

    /**
     * 适用范围 1全国
     */
    private String rangeType;

    /**
     * 组织id
     */
    private Long orgId;

    /**
     * 热门商品 1是 0不是
     */
    private Integer hot;

    /**
     * 分类ID
     */
    private Long category;

    /**
     * 用途（使用二进制存储~~）
     */
    private Integer tags;

    /**
     * 成功率 （1-10代表1-5星）
     */
    private Integer successRate;

    /**
     * 是否上架 1上架 0不上架
     */
    private Integer isShelf;

    /**
     * 图片的URL
     */
    private String itemUrl;

    /**
     * 商品模板ID
     */
    private Long itemTemplateId;

    /**
     * 成功数量
     */
    private Integer successNum;

    /**
     * 申请数量
     */
    private Integer applyNum;

    /**
     * 成功率百分比
     */
    private Double successRatePercentage;

    /**
     * 商品保存步骤
     */
    private String itemSaveNext;

    /**
     * 用途（使用二进制存储~~）
     */
    private Integer useCase;

    /**
     * 二维码内容
     */
    private String erCode;

    private String selectType;

}
