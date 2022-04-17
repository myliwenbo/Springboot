package vip.xjdai.springbootprofile.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class BeanConfig {

    @Profile("dev")
    @Bean
    public BeanA beanADev() {
        return new BeanA("dev");
    }

    @Profile("test")
    @Bean
    public BeanA beanATest() {
        return new BeanA("test");
    }

    @Profile("prd")
    @Bean
    public BeanA beanAPrd() {
        return new BeanA("Prd");
    }


}

