package vip.xjdai.bean.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("vip.xjdai.bean.autowire")
public class AutowiredBeanDemoContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredBeanDemoContext.class);
        AutowiredBeanB bean = context.getBean(AutowiredBeanB.class);
        System.out.println(bean.getAutowiredBeanA());

    }
}
