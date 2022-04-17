package vip.xjdai.springbootbean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanBeanA {
    @Bean
    public BeanBeanB getB() {
        return new BeanBeanB();
    }
}

