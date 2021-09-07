package vip.xjdai.annotation.DependsOn.demo1;

import org.springframework.stereotype.Component;

@Component
public class DependsOnDemoC {
    public DependsOnDemoC() {
        System.out.println(this);
    }
}
