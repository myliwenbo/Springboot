package vip.xjdai.ioc.annotation.b;

import org.springframework.stereotype.Component;

/**
 * @author lwb
 *
 */
@Component
public class ComponentB {

    public ComponentB() {
        System.out.println("初始化：" + this.getClass().getName());
    }

    /**
     * 测试
     */
    public void test() {
        System.out.println("我是:" + this.getClass().getPackage() + "下的方法");
    }
}
