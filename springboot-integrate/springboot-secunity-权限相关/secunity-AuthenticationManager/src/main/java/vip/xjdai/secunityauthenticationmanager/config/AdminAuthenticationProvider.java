package vip.xjdai.secunityauthenticationmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import vip.xjdai.secunityauthenticationmanager.service.MyUserDetailsServiceByDB;

import java.util.Collections;

@Component
public class AdminAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    MyUserDetailsServiceByDB userDetailsService;


    @Override
    public Authentication authenticate(Authentication authentication) {
        // 获取前端表单中输入后返回的用户名、密码
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        //查找用户..
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

        // 验证密码
        if (!userDetails.getPassword().equals(password)) {
            throw new BadCredentialsException("密码错误！");
        }
        // 前后端分离情况下 处理逻辑...
        // 更新登录令牌 - 之后访问系统其它接口直接通过token认证用户权限...
        return new UsernamePasswordAuthenticationToken(userDetails, password, Collections.singleton(new SimpleGrantedAuthority("ROLE_p1")));
    }

    /**
     *
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}