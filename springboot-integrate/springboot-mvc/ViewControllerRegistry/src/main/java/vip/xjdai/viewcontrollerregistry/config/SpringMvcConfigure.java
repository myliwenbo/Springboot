package vip.xjdai.viewcontrollerregistry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class SpringMvcConfigure implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/jsp/");
        viewResolver.setSuffix(".jsp");
        // 这个属性通常并不需要手动配置，高版本的Spring会自动检测
        // viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    //默认Url根路径跳转到/login，此url为spring security提供
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 请求匹配地址 /absent* 时,响应 HTTP代码403给浏览器端
        registry.addStatusController("/absent", HttpStatus.NOT_FOUND);
        // 访问 / 重定向到 login‐view
        registry.addViewController("/").setViewName("redirect:/login-views");
        //  访问 login‐view 返回 login 视图
        registry.addViewController("/login-views").setViewName("index");
    }

}