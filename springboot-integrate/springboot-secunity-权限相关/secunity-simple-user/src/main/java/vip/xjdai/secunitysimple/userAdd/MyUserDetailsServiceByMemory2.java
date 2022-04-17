package vip.xjdai.secunitysimple.userAdd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

/**
 * 采用BCrypt 密码编码器
 */
@Profile("MemoryThree")
public class MyUserDetailsServiceByMemory2 {


    @Bean
    public PasswordEncoder passwordEncoder() {
        // 配置密码编码器
        return new BCryptPasswordEncoder();
    }

    //配置用户信息服务
    @Bean
    public UserDetailsService userDetailsService() {
        // AuthenticationManagerBuilder
        // 初始化的是你和将所有的用户信息放入到 这个里面
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withUsername("zhangsan").password(BCrypt.hashpw("123", BCrypt.gensalt())).authorities("p1").build());
        manager.createUser(
                User.withUsername("lisi").password("123").authorities("p2").build());
        return manager;
    }
}
 