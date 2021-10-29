package vip.xjdai.annotation.Bean;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(name = {"A", "B"}, autowire = Autowire.BY_TYPE)
//    @Bean(name = {"A", "B"})
    public BeanADemo beanADemo() {
        return new BeanADemo();
    }
}
