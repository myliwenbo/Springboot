package vip.xjdai.secunitylogout.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    public static String getProfile() {

        return LogoutSuccessSecurityConfig.class.getSimpleName(); // 自定义退出页面
    }

}
