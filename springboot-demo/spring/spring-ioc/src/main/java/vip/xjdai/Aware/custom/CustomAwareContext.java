package vip.xjdai.Aware.custom;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("vip.xjdai.Aware.custom")
public class CustomAwareContext {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        beanFactory.ignoreDependencyInterface(IgnoreInterface.class); //将我们的自动注入丢进去
        context.register(CustomAwareContext.class);
        context.refresh();
        IgnoreInterfaceImpl bean = context.getBean(IgnoreInterfaceImpl.class);


    }
}
