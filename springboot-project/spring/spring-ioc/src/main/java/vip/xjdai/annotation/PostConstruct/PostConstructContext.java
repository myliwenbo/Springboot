package vip.xjdai.annotation.PostConstruct;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("vip.xjdai.annotation.PostConstruct;")
public class PostConstructContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PostConstructContext.class);


    }
}
