package vip.xjdai.springbootannotationconfigapplicationcontext.spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

@Component
public class ClassPathBeanDefinitionScannerContext {

    public static void main(String[] args) {
        // 创建 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 创建扫描器
        ClassPathBeanDefinitionScanner value = new ClassPathBeanDefinitionScanner(beanFactory);// 这里需要注意不要使用 toString方法
        value.addIncludeFilter(new AnnotationTypeFilter(MyComponent.class));
        value.scan(ClassPathBeanDefinitionScannerContext.class.getPackage().getName());
        // 创建Bean
        MyUser bean = beanFactory.getBean(MyUser.class);
        System.out.println(bean);
    }


}



