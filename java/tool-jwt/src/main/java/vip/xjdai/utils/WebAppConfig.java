package vip.xjdai.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 注册拦截器
 * @author lwb
 *
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport
{

    //关键，将拦截器作为bean写入配置中
    @Bean
    public InterceptorConfig myInterceptor()
    {
        return new InterceptorConfig();
    }

    /**
     * 已定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        //添加拦截器
        registry.addInterceptor(myInterceptor());//添加自定义拦截器
        super.addInterceptors(registry);
    }

}