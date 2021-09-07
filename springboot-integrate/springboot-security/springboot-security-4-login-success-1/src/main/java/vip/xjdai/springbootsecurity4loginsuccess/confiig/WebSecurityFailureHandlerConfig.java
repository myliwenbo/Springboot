package vip.xjdai.springbootsecurity4loginsuccess.confiig;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebSecurityFailureHandlerConfig  extends WebSecurityConfigurerAdapter {
    /**
     **表单配置详解
     **/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//开启登录配置
                .anyRequest().authenticated() //表示访问接口，需要进行认证
                .and()
                .formLogin()
                .loginProcessingUrl("/doLogin")
                .loginPage("/login") //默认的登录页面
                .usernameParameter("user")//定义登录时，用户名的 key，默认为 username
                .passwordParameter("pwd") //定义登录时，用户密码的 key，默认为 password
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request,
                                                        HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        Map<String,Object> map = new HashMap<>();
                        map.put("status",401);
                        if (e instanceof LockedException){
                            map.put("msg","账户被锁定，登录失败");
                        }else if (e instanceof BadCredentialsException){
                            map.put("msg","用户名或密码输入错误，登录失败");
                        }else if (e instanceof DisabledException){
                            map.put("msg","账户被禁用，登录失败");
                        }else if(e instanceof AccountExpiredException){
                            map.put("msg","账户过期，登录失败");
                        }else if (e instanceof CredentialsExpiredException){
                            map.put("msg","密码过期，登录失败");
                        }else {
                            map.put("msg","登录失败");
                        }
                        //浏览器返回json数据
                        out.write(new ObjectMapper().writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()    //和表单登录相关的接口统统都直接通过
                .and()
                .csrf().disable();
    }
}
