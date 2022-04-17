package vip.xjdai.secunitylogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Profile("LoginPageSecurityConfig")
@EnableWebSecurity // 开启WebSecurity
public class LoginPageSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    //重写参数为HttpSecurity的configure方法，配置拦截策略
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 拦截配置
        http.authorizeRequests()
                .antMatchers("/logout/**").anonymous() // 对其进行拦截
                .anyRequest().authenticated(); // 所有的请求都放行
        //关闭 csrf 防护
        //屏蔽CSRF控制，即spring security不再限制CSRF
        http.csrf().disable();
        //表单登陆
        http.formLogin()
                // 自定义登陆页面，默认是 /login
                .loginPage("/login-view")//登录页面
                .loginProcessingUrl("/login")
                .successForwardUrl("/successForwardUrl")
                .permitAll()
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
 