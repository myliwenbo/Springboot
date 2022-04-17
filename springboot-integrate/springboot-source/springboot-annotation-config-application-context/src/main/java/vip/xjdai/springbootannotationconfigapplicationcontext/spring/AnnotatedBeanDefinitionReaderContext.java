package vip.xjdai.springbootannotationconfigapplicationcontext.spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

public class AnnotatedBeanDefinitionReaderContext {
 
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader definitionReader = new AnnotatedBeanDefinitionReader(beanFactory);
        definitionReader.registerBean(User.class);
        User bean = beanFactory.getBean(User.class);
        System.out.println(bean);
    }
    static class User{}
}
