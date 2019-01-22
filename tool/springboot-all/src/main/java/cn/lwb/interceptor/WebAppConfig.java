package cn.lwb.interceptor;

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
public class WebAppConfig extends WebMvcConfigurationSupport {

    //关键，将拦截器作为bean写入配置中
    @Bean
    public ConditionCodeInterceptor myInterceptor() {
        return new ConditionCodeInterceptor();
    }

    /**
     * 静态资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("doc.html")
            .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    /**
     * 已定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(myInterceptor())//添加自定义拦截器
            .addPathPatterns("/**")//添加需要拦截的
            .excludePathPatterns("/swagger-resources", "/v2/api-docs", "/error",
                "/sysuser/*"); //排除需要拦截的
        super.addInterceptors(registry);
    }

    /**
     * 解决JSON跨域问题
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
            .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
            .allowCredentials(false).maxAge(3600);
    }

}
