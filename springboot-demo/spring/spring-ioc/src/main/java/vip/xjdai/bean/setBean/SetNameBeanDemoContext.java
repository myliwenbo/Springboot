package vip.xjdai.bean.setBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("vip.xjdai.bean.setBean")
public class SetNameBeanDemoContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SetNameBeanDemoContext.class);
        SetBeanBDemo bean = context.getBean(SetBeanBDemo.class);
        SetABeanDemoInterface setABeanDemoInterface = bean.getSetABeanDemoInterface();
        System.out.println(setABeanDemoInterface);
    }
}
