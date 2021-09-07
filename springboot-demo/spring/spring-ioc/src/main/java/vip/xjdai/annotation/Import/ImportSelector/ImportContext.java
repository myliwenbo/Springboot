package vip.xjdai.annotation.Import.ImportSelector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class ImportContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportContext.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {

            System.out.println(beanDefinitionName);
        }
    }
}
