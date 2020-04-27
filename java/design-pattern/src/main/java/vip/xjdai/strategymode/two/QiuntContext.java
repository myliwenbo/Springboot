package vip.xjdai.strategymode.two;

import vip.xjdai.strategymode.common.IStrategy;

import java.math.BigDecimal;

/**
 * 策略上下文
 */
public class QiuntContext {

    //持有一个策略实现的引用
    private Customer strategy;

    //使用构造器注入具体的策略类
    public QiuntContext(Customer strategy) {
        this.strategy = strategy;
    }

    public BigDecimal algorithmMethod() {
        //调用策略实现的方法
        return strategy.algorithmMethod(strategy.getMoney());

    }
}