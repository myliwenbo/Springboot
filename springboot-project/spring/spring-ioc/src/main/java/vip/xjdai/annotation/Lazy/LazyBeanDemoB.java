package vip.xjdai.annotation.Lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class LazyBeanDemoB {

    public LazyBeanDemoB() {
        System.out.println("B是不会去创建滴...");
    }
}
