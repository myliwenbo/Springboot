package vip.xjdai.secunitysimple.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    //扩展 springMvc 方法
    public void addViewControllers(ViewControllerRegistry registry) {
        // 默认的WebSecurity的登陆页面
        registry.addViewController("/").setViewName("redirect:/login");
    }

    //重写参数为HttpSecurity的configure方法，配置拦截策略
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
        ;
    }
}
 