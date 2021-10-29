package vip.xjdai.secunitylogout.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Profile("LogoutUrlSecurityConfig")
@EnableWebSecurity // 开启WebSecurity
public class LogoutUrlSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    //重写参数为HttpSecurity的configure方法，配置拦截策略
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //屏蔽CSRF控制，即spring security不再限制CSRF
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/test/**").authenticated() // 对其进行拦截
                .anyRequest().permitAll() // 所有的请求都放行
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logoutSuccessUrl")
        ;
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    //默认Url根路径跳转到/login，此url为spring security提供
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login-view");
        registry.addViewController("/login-view").setViewName("/login");
        registry.addViewController("/logout").setViewName("/logout");
    }

    // @RestController
    @Controller
    @RequestMapping
    public static class LogoutController {

        @RequestMapping("logoutSuccessUrl")
        public String defaultSuccessUrl() {
            // return "退出OJBK";
            return "logout";
        }
    }

}
 