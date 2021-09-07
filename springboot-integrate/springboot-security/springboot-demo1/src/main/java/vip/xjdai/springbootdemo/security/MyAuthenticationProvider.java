package vip.xjdai.springbootdemo.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class MyAuthenticationProvider  implements AuthenticationProvider {

    /**
     * 认证操作
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    /**
     * 如果是当前认证处理器则走走这个操作
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return MyAuthenticationProvider.class.isAssignableFrom(authentication);
    }
}
