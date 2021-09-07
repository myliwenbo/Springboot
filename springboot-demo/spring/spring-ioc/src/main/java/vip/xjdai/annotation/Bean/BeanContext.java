package vip.xjdai.annotation.Bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import vip.xjdai.annotation.Conditional.InterfaceConditionDemoA;

@ComponentScan("vip.xjdai.annotation.Bean")
public class BeanContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanContext.class);
        BeanADemo a = (BeanADemo) context.getBean("A");
        System.out.println(a.getBeanBDemo());
        System.out.println(a.getBeanCDemo());
    }

}
