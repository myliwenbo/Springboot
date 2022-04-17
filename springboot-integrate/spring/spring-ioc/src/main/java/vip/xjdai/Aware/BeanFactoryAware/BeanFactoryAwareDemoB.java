package vip.xjdai.Aware.BeanFactoryAware;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryAwareDemoB implements BeanFactoryAware {


    @Autowired
    BeanFactory beanFactory;


    /**
     * 利用set方法注入一个
     *
     * @param beanFactory
     */
    @Override

    public void setBeanFactory(BeanFactory beanFactory) {
        System.out.println(beanFactory);
    }

    public BeanFactoryAwareDemoB() {
        System.out.println(beanFactory);
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
