package vip.xjdai.annotation.Lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class LazyBeanDemoA {


    @Autowired
    private LazyBeanDemoB lazyBeanDemoB;

    public LazyBeanDemoB getLazyBeanDemoB() {
        return lazyBeanDemoB;
    }

    public LazyBeanDemoA() {
        System.out.println("创建了A");
    }
}
