package vip.xjdai.annotation.Lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import vip.xjdai.annotation.DependsOn.demo1.DependsOnContext;

@ComponentScan("vip.xjdai.annotation.Lazy")
public class LazyContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LazyContext.class);
    }
}
