package vip.xjdai.springbootdesignpattern.strategymode;

import java.math.BigDecimal;

/**
 * 老代码
 * 1. 当改变算法的时候就需要去改动整个函数，当越往后的时候就越冗余
 * 2. 导致后面的这个方法越来越长越来多，甚至可能到达几百行这样
 */
public class QuoteManager {

    /**
     * 这个是一个扫码打折的，根据用户的等级进行打折换算
     *
     * @param originalPrice
     * @param customType
     * @return
     */
    public BigDecimal quote(BigDecimal originalPrice, String customType) {
        if ("新客户".equals(customType)) {
            System.out.println("抱歉！新客户没有折扣！");
            return originalPrice;
        } else if ("老客户".equals(customType)) {
            System.out.println("恭喜你！老客户打9折！");
            originalPrice = originalPrice.multiply(new BigDecimal("0.9")).setScale(2, BigDecimal.ROUND_HALF_UP);
            return originalPrice;
        } else if ("VIP客户".equals(customType)) {
            System.out.println("恭喜你！VIP客户打8折！");
            originalPrice = originalPrice.multiply(new BigDecimal("0.8")).setScale(2, BigDecimal.ROUND_HALF_UP);
            return originalPrice;
        }
        //其他人员都是原价
        return originalPrice;
    }

}