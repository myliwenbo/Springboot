package vip.xjdai.annotation.Import.ImportBeanDefinitionRegistrar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("vip.xjdai.annotation.Import.ImportBeanDefinitionRegistrar")
public class ImportBeanDefinitionRegistrarContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportBeanDefinitionRegistrarContext.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }
}
