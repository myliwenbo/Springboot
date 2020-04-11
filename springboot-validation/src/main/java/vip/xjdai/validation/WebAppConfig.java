package vip.xjdai.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 注册拦截器
 *
 * @author lwb
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {

    //关键，将拦截器作为bean写入配置中
    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }


}