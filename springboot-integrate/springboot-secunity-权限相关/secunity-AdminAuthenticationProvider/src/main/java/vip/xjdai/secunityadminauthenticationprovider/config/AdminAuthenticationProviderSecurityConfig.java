package vip.xjdai.secunityadminauthenticationprovider.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import vip.xjdai.secunityadminauthenticationprovider.service.MyUserDetailsServiceByDB;

@Profile("AdminAuthenticationProvider")
@EnableWebSecurity // 开启WebSecurity
public class AdminAuthenticationProviderSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Autowired
    MyUserDetailsServiceByDB userDetailsService;


    //重写参数为HttpSecurity的configure方法，配置拦截策略

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .and().csrf().disable();
        // 获取验证码提供者
        AdminAuthenticationProvider smsCodeAuthenticationProvider = new AdminAuthenticationProvider(userDetailsService);
        // 将短信验证码校验器注册到 HttpSecurity， 并将短信验证码过滤器添加在 UsernamePasswordAuthenticationFilter 之前
        http.authenticationProvider(smsCodeAuthenticationProvider);
    }
}

 