package vip.xjdai.springbootbeanfactorypostprocessor;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import vip.xjdai.springbootbeanfactorypostprocessor.beanFactory.TestBeanDefinitionRegistryPostProcessor;

import java.util.Iterator;

@ComponentScan
public class SpringbootBeanFactoryPostProcessorApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SpringbootBeanFactoryPostProcessorApplication.class);
        // 自定义添加一个BeanFactroyPostProcessor
        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            // 获取到BeanName的迭代器
            Iterator<String> beanNamesIterator = beanFactory.getBeanNamesIterator();
            //循环输出...
            if (beanNamesIterator.hasNext()) {
                if (beanNamesIterator.next().equals("testBean")) {
                    BeanDefinition testBean = beanFactory.getBeanDefinition("testBean");
                }
            }
        });
        applicationContext.registerBeanDefinition("testBeanFactoryPostProcessor", new RootBeanDefinition(TestBeanDefinitionRegistryPostProcessor.class));
        applicationContext.refresh();
    }

}
