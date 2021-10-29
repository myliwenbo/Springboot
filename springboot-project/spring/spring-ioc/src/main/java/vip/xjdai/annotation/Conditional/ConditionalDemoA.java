package vip.xjdai.annotation.Conditional;


import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConditionalDemoA {

    public ConditionalDemoA() {
        System.out.println("当前类被加载了");
    }
}
