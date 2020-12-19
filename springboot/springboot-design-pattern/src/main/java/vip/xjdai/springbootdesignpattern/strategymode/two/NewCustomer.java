package vip.xjdai.springbootdesignpattern.strategymode.two;

import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;

/**
 * 新客户
 */
public class NewCustomer implements Customer {

    private BigDecimal money;

    public NewCustomer(String money) {
        this.money = new BigDecimal(money);
    }

    /**
     * 根据不同的实现进行不同的算法
     * @param money
     * @return
     */
    @Override
    public BigDecimal algorithmMethod(BigDecimal money) {
        System.out.println("抱歉！新客户没有折扣！");
        System.out.println("折扣金额：" + this.money);
        return money;
    }

    @Override
    public BigDecimal getMoney() {
        return this.money;
    }



}
