package vip.xjdai.springbootsecurity1user.confiig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//这两个注解缺一不可
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder noOpPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

//    //配置用户信息服务
//    @Bean
//    public UserDetailsService userDetailsService() {
//        // AuthenticationManagerBuilder
//        // 初始化的是你和将所有的用户信息放入到 这个里面
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(
//                User.withUsername("zhangsan").password("123").authorities("p1").build());
//        manager.createUser(
//                User.withUsername("lisi").password("456").authorities("p2").build());
//        return manager;
//    }

//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("zhangsan2")
//                .password("123456")
//                .roles("VIP1", "VIP2")
//                .and()
//                .withUser("lisi2")
//                .password("123456")
//                .roles("VIP1", "VIP3")
//                .and()
//                .withUser("wangwu2")
//                .password("123456")
//                .roles("VIP2", "VIP3");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/SecurityLoginSuccess/**").authenticated() //所有请求都进行拦截，且没有权限就能访问
                .anyRequest().permitAll()// 其他的放行
                .and()

                .formLogin() //允许表单登陆

                .successForwardUrl("/SecurityLoginSuccess/test")
                .and()
                .logout()
                .deleteCookies();
    }
}
 