package vip.xjdai.annotation.Import.ImportBeanDefinitionRegistrar;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //importingClassMetadata 当前类的注解信息

//        registry.containsBeanDefinition() //判断容器中是否有这个Bean
//        registry.getBeanDefinition() //根据名字获取 BeanDefinition
        registry.registerBeanDefinition("aaa", new RootBeanDefinition(ImportBeanDefinitionRegistrarBeanDemoA.class));// 注册一个Bean

    }
}
