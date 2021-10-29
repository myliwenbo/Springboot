package vip.xjdai.ApplicationContext.AnnotationConfigApplicationContext.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;



public class MyAnnotationConfigApplicationContextBeanA {

    public MyAnnotationConfigApplicationContextBeanA() {
        System.out.println("MyAnnotationConfigApplicationContextBeanA 执行了");
    }
}
