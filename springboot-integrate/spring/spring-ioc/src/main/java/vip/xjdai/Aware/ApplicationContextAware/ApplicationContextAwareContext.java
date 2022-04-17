package vip.xjdai.Aware.ApplicationContextAware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("vip.xjdai.Aware.ApplicationContextAware")
public class ApplicationContextAwareContext {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextAwareContext.class);
        ApplicationContextAwareDemoA bean = context.getBean(ApplicationContextAwareDemoA.class);
        bean.getApplicationContext();

    }
}
