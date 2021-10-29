package vip.xjdai.viewresolverjsp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class SpringMvcConfigure {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/jsp/");
        viewResolver.setSuffix(".jsp");
        // 这个属性通常并不需要手动配置，高版本的Spring会自动检测
        // viewResolver.setViewClass(JstlView.class); 
        return viewResolver;
    }
}