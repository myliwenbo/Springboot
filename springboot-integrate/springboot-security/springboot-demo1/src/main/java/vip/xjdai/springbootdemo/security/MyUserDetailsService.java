package vip.xjdai.springbootdemo.security;

import cn.hutool.crypto.digest.MD5;
import com.google.common.collect.Maps;
import com.sun.applet2.AppletParameters;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Component
    static class MyPasswordEncoder implements PasswordEncoder {

        @Override
        public String encode(CharSequence rawPassword) {
            return MD5.create().digestHex16(rawPassword.toString());
        }

        /**
         * 验证
         *
         * @param rawPassword
         * @param encodedPassword
         * @return
         */
        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            return encodedPassword.equals(MD5.create().digestHex16(rawPassword.toString()));
        }
    }

    private static final Map<String, UserDetails> stringUserDetailsMap = Maps.newHashMap();

    static {
        stringUserDetailsMap.put("zhangsan", User.withUsername("张三")
                .password(MD5.create().digestHex16("123"))
                .roles("p1").build());
        stringUserDetailsMap.put("lisii", User.withUsername("张三")
                .password(MD5.create().digestHex16("123"))
                .roles("p2").build());
    }

    // 给定一个的信息去数据库查询或者redis 中查询..
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 去数据库查询..
        System.out.println("数据库查询中或者redis，或者查询完后放入到redis中..");
        return stringUserDetailsMap.get(username);
    }
}
