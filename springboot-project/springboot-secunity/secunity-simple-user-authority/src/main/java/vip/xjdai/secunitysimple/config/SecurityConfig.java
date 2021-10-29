package vip.xjdai.secunitysimple.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import vip.xjdai.secunitysimple.config.secunity.WebSecurityConfig;


@EnableWebSecurity // 开启WebSecurity
public class SecurityConfig {


    @Bean
    WebSecurityConfig webSecurityConfig() {
        return new WebSecurityConfig();
    }

}
 