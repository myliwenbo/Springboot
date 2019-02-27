package vip.xjdai.ioc.annotation.c;

import org.springframework.stereotype.Component;

/**
 * @author lwb
 *
 */
@Component
public class ComponentC {

    public ComponentC() {
        System.out.println("初始化：" + this.getClass().getName());
    }

    /**
     * 
     */
    public void test() {
        System.out.println("调用任务：" + this.getClass().getName() + ".test");
    }

}
