package vip.xjdai.annotation.DependsOn.demo1;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@DependsOn("dependsOnDemoB") //先去创建B，在去创建A
@Component
public class DependsOnDemoA {

    public DependsOnDemoA() {
        System.out.println(this);
    }
}
