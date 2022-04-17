package vip.xjdai.secunitylogin.config;

import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Profile("LoginSuccessPageSecurityConfig")
@EnableWebSecurity // 开启WebSecurity
public class LoginSuccessPageSecurityConfig extends WebSecurityConfigurerAdapter {
    //重写参数为HttpSecurity的configure方法，配置拦截策略
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin() //表单登陆
                // 相当于创建了 new ForwardAuthenticationSuccessHandler("/defaultSuccessUrl")
                // .successForwardUrl("/defaultSuccessUrl")
                // 相当于创建了 new SavedRequestAwareAuthenticationSuccessHandler()
                .defaultSuccessUrl("/defaultSuccessUrl",false)
        ;
    }
}
