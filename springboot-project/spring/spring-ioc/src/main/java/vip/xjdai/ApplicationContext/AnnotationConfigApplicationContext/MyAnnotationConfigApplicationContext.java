package vip.xjdai.ApplicationContext.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Conditional;


public class MyAnnotationConfigApplicationContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("vip.xjdai.ApplicationContext.AnnotationConfigApplicationContext");
        context.refresh();
    }
}
