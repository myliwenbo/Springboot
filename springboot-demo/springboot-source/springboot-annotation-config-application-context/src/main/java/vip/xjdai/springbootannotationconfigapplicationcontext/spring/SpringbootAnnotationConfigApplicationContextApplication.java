package vip.xjdai.springbootannotationconfigapplicationcontext.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses=SpringbootAnnotationConfigApplicationContextApplication.class)
public class SpringbootAnnotationConfigApplicationContextApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringbootAnnotationConfigApplicationContextApplication.class);
    }

}
