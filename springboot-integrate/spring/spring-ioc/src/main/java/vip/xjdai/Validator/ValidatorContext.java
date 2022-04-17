package vip.xjdai.Validator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("vip.xjdai.Validator")
public class ValidatorContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ValidatorContext.class);
//        context

    }
}
