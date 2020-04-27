package vip.xjdai.strategymode.common;

/**
 * 新客户
 */
public class IStrategy1 implements IStrategy {

    @Override
    public void algorithmMethod() {
        System.out.println("抱歉！新客户没有折扣！");
    }
}
