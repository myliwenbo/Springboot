package vip.xjdai.annotation.DependsOn.demo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;

@ComponentScan("vip.xjdai.annotation.DependsOn.demo2")
public class DependsOnContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DependsOnContext.class);

    }


    @Bean(initMethod = "initialize")
    @DependsOn("eventListener") //先去创建
    public EventPublisherBean eventPublisherBean() {
        return new EventPublisherBean();
    }

    @Bean(name = "eventListener", initMethod = "initialize")
    public EventListenerBean eventListenerBean() {
        return new EventListenerBean();
    }
}
