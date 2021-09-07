package vip.xjdai.springbootdesignpattern.strategymode;

import java.math.BigDecimal;

/**
 * 使用策略模式进行处理
 * 1. 将算法进行抽离成一个接口方法，进行限制处理
 * 2. 产生问题，当新增客户级别的时候就要进行新的 if...elese添加和新的处理方法，违背了闭合原则
 */
public class TwoQuoteManager {

    /**
     * 这个是一个扫码打折的，根据用户的等级进行打折换算
     *
     * @param originalPrice
     * @param customType
     * @return
     */
    public BigDecimal quote(BigDecimal originalPrice, String customType) {
        if ("新客户".equals(customType)) {
            return this.newCustomer(originalPrice);
        } else if ("老客户".equals(customType)) {
            return this.quoteOldCustomer(originalPrice);
        } else if ("VIP客户".equals(customType)) {
            return this.quoteVIPCustomer(originalPrice);
        }
        //其他人员都是原价
        return originalPrice;
    }

    public BigDecimal quote1(BigDecimal originalPrice, String customType) {
        if ("新客户".equals(customType)) {
            return this.newCustomer(originalPrice);
        } else if ("老客户".equals(customType)) {
            return this.quoteOldCustomer(originalPrice);
        } else if ("VIP客户1".equals(customType)) {
            return this.quoteVIPCustomer(originalPrice);
        } else if ("VIP客户2".equals(customType)) {
            return this.quoteVIPCustomer(originalPrice);
        } else if ("VIP客户3".equals(customType)) {
            return this.quoteVIPCustomer(originalPrice);
        } else if ("VIP客户4".equals(customType)) {
            return this.quoteVIPCustomer(originalPrice);
        } else if ("VIP客户5".equals(customType)) {
            return this.quoteVIPCustomer(originalPrice);
        } else if ("VIP客户6".equals(customType)) {
            return this.quoteVIPCustomer(originalPrice);
        }
        //其他人员都是原价
        return originalPrice;
    }


    /**
     * 对VIP客户的报价算法
     *
     * @param originalPrice 原价
     * @return 折后价
     */
    private BigDecimal quoteVIPCustomer(BigDecimal originalPrice) {
        System.out.println("恭喜！VIP客户打8折");
        originalPrice = originalPrice.multiply(new BigDecimal("0.8")).setScale(2, BigDecimal.ROUND_HALF_UP);
        return originalPrice;
    }

    /**
     * 对老客户的报价算法
     *
     * @param originalPrice 原价
     * @return 折后价
     */
    private BigDecimal quoteOldCustomer(BigDecimal originalPrice) {
        System.out.println("恭喜！老客户打9折");
        originalPrice = originalPrice.multiply(new BigDecimal("0.9")).setScale(2, BigDecimal.ROUND_HALF_UP);
        return originalPrice;
    }

    private BigDecimal newCustomer(BigDecimal originalPrice) {
        System.out.println("抱歉！新客户没有折扣！");
        return originalPrice;
    }
}