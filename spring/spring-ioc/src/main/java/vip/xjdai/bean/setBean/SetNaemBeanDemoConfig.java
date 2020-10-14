package vip.xjdai.bean.setBean;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SetNaemBeanDemoConfig {

    @Bean(autowire = Autowire.BY_TYPE)
//    @Bean
    public SetBeanBDemo setBeanBDemo() {
        return new SetBeanBDemo();
    }
}
