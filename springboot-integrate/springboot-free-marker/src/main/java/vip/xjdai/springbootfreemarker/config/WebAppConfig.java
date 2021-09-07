package vip.xjdai.springbootfreemarker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 注册拦截器
 *
 * @author lwb
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {


    /**
     * 自定义资源拦截器
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //添加映射路径，表示访问当前文件下的资源不需要加前缀即可访问
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");//指的是对外暴露的访问路径
        super.addResourceHandlers(registry);
    }

}