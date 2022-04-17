package vip.xjdai.secunityadminauthenticationprovider.service;

import cn.hutool.crypto.digest.MD5;
import com.google.common.collect.Maps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MyUserDetailsServiceByDB implements UserDetailsService {

    @Profile("AdminAuthenticationProvider")
    @Bean
    public PasswordEncoder noOpPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Profile("AbstractUserDetailsAuthenticationProviderDemo")
    @Bean
    public PasswordEncoder md5PasswordEncoder() {
        return new PasswordEncoder() {
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
                return encodedPassword.equals(encode(rawPassword));
            }
        };
    }

    // 给定一个的信息去数据库查询或者redis中查询..
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map<String, UserDetails> stringUserDetailsMap = Maps.newHashMap();
        stringUserDetailsMap.put("zhangsan", User.withUsername("张三")
//                .password(NoOpPasswordEncoder.getInstance().encode("123"))
                .password("123456")
                .roles("p1").build());
        stringUserDetailsMap.put("lisi", User.withUsername("李四")
//                .password(NoOpPasswordEncoder.getInstance().encode("123"))
                .password("123456")
                .roles("p2").build());
        // 去数据库查询..
        System.out.println("数据库查询中或者redis，或者查询完后放入到redis中..");
        return stringUserDetailsMap.get(username);
    }
}