package vip.xjdai.sign;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.collect.Lists;

/**
 * 注册jackson
 *
 * @author lwb
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    //关键，将拦截器作为bean写入配置中
    @Bean
    public ConditionCodeInterceptor myInterceptor() {
        return new ConditionCodeInterceptor();
    }

    /**
     * 已定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //1. 添加需要排除的拦截
        List<String> exclude = Lists.newArrayList();
        exclude.add("/swagger-resources");
        exclude.add("/v2/api-docs");
        exclude.add("/error");
        exclude.add("/test/test");
        //添加拦截器
        registry.addInterceptor(myInterceptor())//添加自定义拦截器
                .addPathPatterns("/**")//添加需要拦截的
                .excludePathPatterns(exclude); //排除需要拦截的
        super.addInterceptors(registry);
    }

}