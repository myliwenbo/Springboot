package vip.xjdai.BeanFactoryPostProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("vip.xjdai.BeanFactoryPostProcessor")
public class MyBeanFactoryPostProcessorScan {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyBeanFactoryPostProcessorScan.class);
    }
}
