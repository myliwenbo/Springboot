package vip.xjdai.springbootdesignpattern.strategymode.common;


/**
 * 策略上下文
 */
public class StrategyContext {

    //持有一个策略实现的引用
    private final IStrategy strategy;

    //使用构造器注入具体的策略类
    public StrategyContext(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void contextMethod() {
        //调用策略实现的方法
        strategy.algorithmMethod();
    }
}