package vip.xjdai.secunitylogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.PrintWriter;

@Profile("LoginErrorSecurityConfig")
@EnableWebSecurity // 开启WebSecurity
public class LoginErrorSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {


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
                .loginProcessingUrl("/login")
                // 用户如果在验证之前访问过安全页面，则在验证成功后用户将被重定向到该访问页面，不然就会跳转到默认的配置的页面
                .defaultSuccessUrl("/defaultSuccessUrl")
                // .successForwardUrl("/defaultSuccessUrl")
                .and()
                .exceptionHandling()
                // 默认的会跳转到登陆页面，也就是说访问未授权的页面的会话
                .authenticationEntryPoint((req, resp, authException) -> {
                            resp.setContentType("application/json;charset=utf-8");
                            PrintWriter out = resp.getWriter();
                            out.write("尚未登录，请先登录");
                            out.flush();
                            out.close();
                        }
                )

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
        //  这里为了演示才这么做跳转的
        registry.addViewController("/").setViewName("redirect:/login-view");
        // 当IDEA 配置完后是能进行跳转到 login的
        registry.addViewController("/login*").setViewName("login");

    }

}
