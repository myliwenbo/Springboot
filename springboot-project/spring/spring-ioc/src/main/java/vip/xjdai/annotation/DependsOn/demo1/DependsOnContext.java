package vip.xjdai.annotation.DependsOn.demo1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;


@ComponentScan("vip.xjdai.annotation.DependsOn.demo1")
public class DependsOnContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DependsOnContext.class);
    }

}
