package vip.xjdai.springbootdesignpattern.strategymode.common;

import java.math.BigDecimal;

//策略接口
public interface IStrategy {
    //定义的抽象算法方法 来约束具体的算法实现方法
    public void algorithmMethod();
}