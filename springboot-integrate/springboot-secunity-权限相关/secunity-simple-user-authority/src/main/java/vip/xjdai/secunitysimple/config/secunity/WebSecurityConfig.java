package vip.xjdai.secunitysimple.config.secunity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;


public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {


    //重写参数为HttpSecurity的configure方法，配置拦截策略

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .and().csrf().disable();
        http.addFilterAt(tokenLoginFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    TokenLoginFilter tokenLoginFilter() throws Exception {
        TokenLoginFilter filter = new TokenLoginFilter();
        filter.setAuthenticationSuccessHandler((req, resp, authentication) -> {
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            HashMap<String, String> objectObjectHashMap = Maps.newHashMap();
            objectObjectHashMap.put("st", "200");
            objectObjectHashMap.put("ms", "成功");
            out.write(new ObjectMapper().writeValueAsString(objectObjectHashMap));
            out.flush();
            out.close();
        });
        filter.setAuthenticationFailureHandler((req, resp, e) -> {
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            HashMap<String, String> objectObjectHashMap = Maps.newHashMap();
            objectObjectHashMap.put("st", "404");
            objectObjectHashMap.put("ms", "失败");
            out.write(new ObjectMapper().writeValueAsString(objectObjectHashMap));
            out.flush();
            out.close();
        });
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }
}
 