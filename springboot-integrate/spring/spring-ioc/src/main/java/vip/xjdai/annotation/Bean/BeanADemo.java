package vip.xjdai.annotation.Bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanADemo implements BeanADemoInterface {


    private BeanBDemoInterface beanBDemo;

    private BeanCDemo beanCDemo;

    public BeanCDemo getBeanCDemo() {
        return beanCDemo;
    }

    public void setBeanCDemo(BeanCDemo beanCDemo) {
        this.beanCDemo = beanCDemo;
    }
    //    public void Sout() {
//        System.out.println(beanBDemo);
//    }

    public BeanBDemoInterface getBeanBDemo() {
        return beanBDemo;
    }

    @Override
    public void setBeanBDemo(BeanBDemoInterface beanBDemo) {
        this.beanBDemo = beanBDemo;
    }


//
//    private ApplicationContext applicationContext;
//
//    public ApplicationContext getApplicationContext() {
//        return applicationContext;
//    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
}
