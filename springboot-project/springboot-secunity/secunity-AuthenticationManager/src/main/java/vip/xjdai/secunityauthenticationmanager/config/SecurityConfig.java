package vip.xjdai.secunityauthenticationmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebSecurity // 开启WebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Autowired
    private CusAuthenticationManager cusAuthenticationManager;

    //重写参数为HttpSecurity的configure方法，配置拦截策略

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .and().csrf().disable();
        http.setSharedObject(AuthenticationManager.class, cusAuthenticationManager);
    }
}

 