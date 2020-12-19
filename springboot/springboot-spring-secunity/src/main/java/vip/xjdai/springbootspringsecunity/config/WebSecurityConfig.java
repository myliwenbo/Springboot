package vip.xjdai.springbootspringsecunity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 1. 采用继承的方式
 * 2. 采用注解的方式 @OAuth2WebSecurityConfiguration
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 配置拦截请求资源
     * @param http：HTTP请求安全处理
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()  //HTTP Basic认证方式
            .and()
            .authorizeRequests()  // 授权配置
            .anyRequest()  // 所有请求
            .authenticated(); // 都需要认证
    }
}