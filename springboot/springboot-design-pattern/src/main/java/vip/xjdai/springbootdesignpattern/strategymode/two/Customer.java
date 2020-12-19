package vip.xjdai.springbootdesignpattern.strategymode.two;

import java.math.BigDecimal;

//策略接口
public interface Customer {
    //定义的抽象算法方法 来约束具体的算法实现方法
    public BigDecimal algorithmMethod(BigDecimal money);
    //定义抽象的获取金额的方法，有具体的实现来处理，防止不遵守规则
    public BigDecimal getMoney();

}