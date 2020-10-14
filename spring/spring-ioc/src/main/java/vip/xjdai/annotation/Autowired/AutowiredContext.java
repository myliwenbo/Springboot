package vip.xjdai.annotation.Autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import vip.xjdai.annotation.Bean.BeanADemo;

@ComponentScan("vip.xjdai.annotation.Autowired")
public class AutowiredContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredContext.class);
        AutowiredBeanDemoA bean = context.getBean(AutowiredBeanDemoA.class);
        System.out.println(bean.getAutowiredBeanDemoB());
//        bean.getSout();
    }

}
