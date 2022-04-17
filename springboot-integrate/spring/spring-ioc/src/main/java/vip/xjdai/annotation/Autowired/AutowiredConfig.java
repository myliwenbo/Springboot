package vip.xjdai.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowiredConfig {


    @Bean(autowire = Autowire.BY_TYPE)
    public AutowiredBeanDemoA autowiredBeanDemoA() {
        return new AutowiredBeanDemoA();
    }

}
