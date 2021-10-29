package vip.xjdai.Aware.BeanFactoryAware;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import vip.xjdai.Aware.ApplicationContextAware.ApplicationContextAwareContext;
import vip.xjdai.Aware.ApplicationContextAware.ApplicationContextAwareDemoA;

@ComponentScan("vip.xjdai.Aware.BeanFactoryAware")
public class BeanFactoryAwareContext {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanFactoryAwareContext.class);
        BeanFactoryAwareDemoB bean = context.getBean(BeanFactoryAwareDemoB.class);
        BeanFactory beanFactory = bean.getBeanFactory();

    }
}
