package vip.xjdai.annotation.DependsOn.demo1;

import org.springframework.stereotype.Component;

@Component
public class DependsOnDemoB {
    public DependsOnDemoB() {
        System.out.println(this);
    }
}
