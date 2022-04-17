package vip.xjdai.secunitysimple.userAdd;

import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 另外一种方式
 */
@Profile("MemoryTwo")
public class MyUserDetailsServiceByMemory1 extends WebSecurityConfigurerAdapter {

    //重写参数为HttpSecurity的configure方法，配置拦截策略
    @Override
    protected void configure(AuthenticationManagerBuilder http) throws Exception {
        http.inMemoryAuthentication()
                .withUser("zhangsan")
                .password("123")
                .and()
                .withUser("lisi")
                .password("123")
        ;
    }
}
 