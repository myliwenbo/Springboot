package vip.xjdai.secunitysimple.userAdd;

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

/**
 * 自定义密码解码器
 */
@Profile("db1")
public class MyUserDetailsServiceByDB1 implements UserDetailsService {

    @Component
    static class MyPasswordEncoder implements PasswordEncoder {
        private static final MyPasswordEncoder INSTANCE = new MyPasswordEncoder();

        public static MyPasswordEncoder getInstance() {
            return INSTANCE;
        }

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
    }


    // 给定一个的信息去数据库查询或者redis中查询..
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map<String, UserDetails> stringUserDetailsMap = Maps.newHashMap();
        stringUserDetailsMap.put("zhangsan",
                User.withUsername("张三").password(
                        // 需要对密码进行一个加密动作，也就是，存在数据库的密码是需要加密过的
                        MyPasswordEncoder.INSTANCE.encode("123")).authorities("p2").build()
        );
        stringUserDetailsMap.put("lisi",
                User.withUsername("李四").password(
                        // 需要对密码进行一个加密动作，也就是，存在数据库的密码是需要加密过的
                        MyPasswordEncoder.INSTANCE.encode("123")).authorities("p2").build()
        );
        // 去数据库查询..
        System.out.println("数据库查询中或者redis，或者查询完后放入到redis中..");
        return stringUserDetailsMap.get(username);
    }
}