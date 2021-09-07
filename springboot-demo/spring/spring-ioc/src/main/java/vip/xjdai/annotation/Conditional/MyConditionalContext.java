package vip.xjdai.annotation.Conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;

@Conditional(InterfaceConditionDemoA.class)
@ComponentScan("vip.xjdai.annotation.Conditional")
public class MyConditionalContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConditionalContext.class);
    }

}
