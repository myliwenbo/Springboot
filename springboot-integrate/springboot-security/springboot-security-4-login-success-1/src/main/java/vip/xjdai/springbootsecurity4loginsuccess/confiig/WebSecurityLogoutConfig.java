package vip.xjdai.springbootsecurity4loginsuccess.confiig;

import cn.hutool.crypto.digest.MD5;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Profile("logout")
//这两个注解缺一不可
@Configuration
@EnableWebSecurity
public class WebSecurityLogoutConfig extends WebSecurityConfigurerAdapter {


    //配置用户信息服务
    @Bean
    public UserDetailsService userDetailsService() {
        // AuthenticationManagerBuilder
        // 初始化的是你和将所有的用户信息放入到 这个里面
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withUsername("zhangsan").password(MD5.create().digestHex16("123")).authorities("p2").build());
        manager.createUser(
                User.withUsername("lisi").password("123").authorities("p2").build());
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/SecurityLoginSuccess/**").authenticated() //所有请求都进行拦截，且没有权限就能访问
                .anyRequest().permitAll()// 其他的放行
                .and()
                .logout()
                .logoutUrl("") // 指定登出页面的处理地址，默认：/logout
                .logoutSuccessUrl("")// 退出成功页面，默认：/login?logout
                // 指定登出成功后的处理handler，指定了这个的话，上面的logoutSuccessUrl()就失效了。
                // .logoutSuccessHandler(null)
                // 指定是否在登出的时候使session失效，默认：true。
                .invalidateHttpSession(true)
                //指定登出的处理handler，简单来说可以用来处理一些逻辑，比如清楚缓存..
                .addLogoutHandler(null)
                // 退出登陆匹配
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                // 可以进行指定删除 cookies
                .deleteCookies()
                .and().csrf().disable();//解决必须是POST 请求才能 /logout
    }
}
