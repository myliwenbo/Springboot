package vip.xjdai.strategymode;

import java.math.BigDecimal;

/**
 * 进阶： 将代码抽离成一个个的 函数，当需要改变的时候只需要改动某函数就好了
 * 1. 这样的业务逻辑更加清晰，当需要更新客户的业务的时候只需要找到对应的方法即可
 * 2. 产生新的问题，就是如果当我们增加新的条件规则的时候是不是还得继续添加 if...else
 *  比如：VIP等级，等级越高打折就越高，最高腿打折
 */
public class OneQuoteManager {

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
        }else if ("VIP客户2".equals(customType)) {
            return this.quoteVIPCustomer(originalPrice);
        }else if ("VIP客户3".equals(customType)) {
            return this.quoteVIPCustomer(originalPrice);
        }else if ("VIP客户4".equals(customType)) {
            return this.quoteVIPCustomer(originalPrice);
        }else if ("VIP客户5".equals(customType)) {
            return this.quoteVIPCustomer(originalPrice);
        }else if ("VIP客户6".equals(customType)) {
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