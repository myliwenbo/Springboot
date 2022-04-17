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
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 另外一种方式
 */

@Profile("Memory")
public class MyUserDetailsServiceByMemory {


    @Bean
    public PasswordEncoder noOpPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    //配置用户信息服务
    @Bean
    public UserDetailsService userDetailsService() {
        // AuthenticationManagerBuilder
        // 初始化的是你和将所有的用户信息放入到 这个里面
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withUsername("zhangsan").password("123").authorities("p1").build());
        manager.createUser(
                User.withUsername("lisi").password("123").authorities("p1").build());
        return manager;
    }
}
 