package vip.xjdai.secunitylogout.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义退出 Handler ..
 */
@Profile("InvalidateHttpSessionSecurityConfig")
@EnableWebSecurity // 开启WebSecurity
public class InvalidateHttpSessionSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    //重写参数为HttpSecurity的configure方法，配置拦截策略
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //屏蔽CSRF控制，即spring security不再限制CSRF
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/test/**").authenticated() // 对其进行拦截
                .anyRequest().permitAll() // 所有的请求都放行
                .and()
                //表单登陆
                .formLogin()
                // 自定义登陆页面，默认是 /login
                .loginPage("/login-view")//登录页面
                .successForwardUrl("/test/test")
                .and()
                .logout()
                // 指定是否在登出的时候使session失效，默认：true。
                .invalidateHttpSession(true)
                // 退出的时候删除认证..
                .clearAuthentication(true)
                .deleteCookies("")  // 退出的时候删除 cookies//
                // 自定义退出 Handler
                .addLogoutHandler((request, response, authentication) -> {

                })
        ;
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        // 这个属性通常并不需要手 动配置，高版本的Spring会自动检测
        // viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    //默认Url根路径跳转到/login，此url为spring security提供
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");
    }
}
 