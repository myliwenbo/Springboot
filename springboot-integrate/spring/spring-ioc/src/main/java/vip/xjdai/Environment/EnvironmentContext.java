package vip.xjdai.Environment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;


@ComponentScan("vip.xjdai.Environment")
public class EnvironmentContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();
        ConfigurableEnvironment environment = context.getEnvironment();
//        environmen
    }
}
