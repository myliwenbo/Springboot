package vip.xjdai.secunityadminauthenticationprovider.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collections;

/**
 * 直接实现接口然后编写认证
 */
public class AdminAuthenticationProvider implements AuthenticationProvider {
    private final UserDetailsService userDetailsService;

    /**
     * 传递一个用户查找的类..
     *
     * @param userDetailsService
     */
    public AdminAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

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
        // 更新登录令牌 - 之后访问系统其它接口直接通过 token 认证用户权限...
        return new UsernamePasswordAuthenticationToken(userDetails, password, Collections.singleton(new SimpleGrantedAuthority("ROLE_p1")));
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}