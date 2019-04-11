package cn.lwb.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 注册拦截器
 * 
 * @author lwb
 *
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 第三方URL<url>com.github.xiaoymin</url>
         */
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("doc.html")
            .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");

        /**
         * 官方URL
         */
        registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    /**
     * 已定义拦截器，如果添加了
     */
    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    // // 如果有拦截器需要排除 swagger的拦截
    // // registry.addInterceptor(new InterceptorConfig())// 添加自定义拦截器
    // // .addPathPatterns("/**")// 添加需要拦截的
    // // .excludePathPatterns("/swagger-resources", "/v2/api-docs", "/error", "/sysuser/*"); // 排除需要拦截的
    // // super.addInterceptors(registry);
    // }
}