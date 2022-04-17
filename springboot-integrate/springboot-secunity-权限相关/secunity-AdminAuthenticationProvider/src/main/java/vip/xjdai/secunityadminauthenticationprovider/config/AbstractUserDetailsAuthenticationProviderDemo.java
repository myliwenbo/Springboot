package vip.xjdai.secunityadminauthenticationprovider.config;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 会去调用父类的 authenticate 方法 进行验证..
 */
public class AbstractUserDetailsAuthenticationProviderDemo extends AbstractUserDetailsAuthenticationProvider {
    /**
     * 缓存信息，
     */
    private final UserCache userCache;
    /**
     * 密码编码Code，也可以认为是密码对比
     */
    private final PasswordEncoder passwordEncoder;
    /**
     * 用户Service 主要用于查找用户
     */
    private final UserDetailsService userDetailsService;

    public AbstractUserDetailsAuthenticationProviderDemo(UserCache userCache, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.userCache = userCache;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }


    /**
     * 对用户信息进行验证..
     *
     * @param userDetails
     * @param authentication
     * @throws AuthenticationException
     */
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // 用户输入的密码
        if (authentication.getCredentials() == null) {
            logger.debug("用户尚未输入密码..");
            throw new BadCredentialsException("自定义异常：用户未输入密码");
        }

        String presentedPassword = authentication.getCredentials().toString();

        if (!passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
            logger.debug("验证失败：密码不一致");
            throw new BadCredentialsException("自定义异常：密码错误");
        }
    }

    /**
     * 用户的查找...
     *
     * @param username
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        //查找用户..
        UserDetails loadedUser = userDetailsService.loadUserByUsername(username);
        if (loadedUser == null) {
            throw new InternalAuthenticationServiceException("用户查询返回null.. 违反查询接口");
        }
        return loadedUser;

    }
}
