package vip.xjdai.secunitysimple.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import vip.xjdai.secunitysimple.userAdd.*;


@Import({MyUserDetailsServiceByDB.class,
        MyUserDetailsServiceByMemory.class
        , MyUserDetailsServiceByMemory1.class, MyUserDetailsServiceByMemory2.class,
        MyUserDetailsServiceByDB1.class
})

@EnableWebSecurity // 开启WebSecurity
public class SecunityConfig {

    //    public static String profile = "db";
    public static String profile = "db1";
    //    public static String profile = "Memory";
    //    public static String profile = "MemoryTwo";
    //    采用自定义密码编码器
//    public static String profile = "MemoryThree";


    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfig();
    }


}
