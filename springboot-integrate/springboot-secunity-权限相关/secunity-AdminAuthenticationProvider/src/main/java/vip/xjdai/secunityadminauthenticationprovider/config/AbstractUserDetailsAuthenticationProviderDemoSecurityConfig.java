package vip.xjdai.secunityadminauthenticationprovider.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import vip.xjdai.secunityadminauthenticationprovider.service.MyUserDetailsServiceByDB;

@Profile("AbstractUserDetailsAuthenticationProviderDemo")
@EnableWebSecurity // 开启WebSecurity
public class AbstractUserDetailsAuthenticationProviderDemoSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Autowired
    MyUserDetailsServiceByDB userDetailsService;

    @Autowired
    PasswordEncoder md5PasswordEncoder;

    /**
     * 自定义缓存，目前用的 spring 自带的可以自己去实现这个接口，然后自己去定义这个内容
     *
     * @return
     */
    @Bean
    public SpringCacheBasedUserCache springCacheBasedUserCache() {
        return new SpringCacheBasedUserCache(new ConcurrentMapCache("SecurityUser"));
    }


    //重写参数为HttpSecurity的configure方法，配置拦截策略
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest().authenticated()  //所有请求都进行拦截，只能登录后访问，可以没有权限就能访问
                .and()
                .formLogin()
                .and().csrf().disable(); // 添加 CSRF 支持
        // 获取验证码提供者
        AbstractUserDetailsAuthenticationProviderDemo smsCodeAuthenticationProvider =
                new AbstractUserDetailsAuthenticationProviderDemo(springCacheBasedUserCache(), md5PasswordEncoder, userDetailsService);
        // 将短信验证码校验器注册到 HttpSecurity， 并将短信验证码过滤器添加在 UsernamePasswordAuthenticationFilter 之前
        http.authenticationProvider(smsCodeAuthenticationProvider);
    }
}

 