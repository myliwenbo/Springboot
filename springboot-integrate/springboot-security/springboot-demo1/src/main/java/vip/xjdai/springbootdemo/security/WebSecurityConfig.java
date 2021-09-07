package vip.xjdai.springbootdemo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//这两个注解缺一不可
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    //扩展 springMvc 方法
    public void addViewControllers(ViewControllerRegistry registry){
        // 默认的WebSecurity的登陆页面
        registry.addViewController("/").setViewName("redirect:/login");
    }
    //重写参数为HttpSecurity的configure方法，配置拦截策略
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/sysTest/test1").hasAuthority("p1") //必须存在p1 权限
                .antMatchers("/sysTest/test2").hasAuthority("p1") //必须存在p2 权限
                .antMatchers("/sysTest/**").authenticated() //所有请求都进行拦截，且没有权限就能访问
                .anyRequest().permitAll()// 其他的放行
                .and()
                .formLogin() //允许表单登陆
                .successForwardUrl("/loginContoller/test")
                .and()
                .logout()
                .deleteCookies();
        ; //登陆成功后的页面
//                //自定义登陆页面
//                .formLogin().loginPage("/login")
//                //登陆成功后跳转的页面
//                .defaultSuccessUrl("/index")
//                //登陆失败或无权限跳转页面
//                .failureUrl("/login-error")
//                // 所有用户都可以访问
//                .permitAll()
//                //其他所有页面必须验证后才可以访问
//                .and().authorizeRequests().anyRequest().authenticated()
//                //不加上不验证。不知道为什么
//                .and().csrf().disable();

    }

}
