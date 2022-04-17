package vip.xjdai.secunitylogin.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    public static String getProfile() {
        return LoginSuccessPageSecurityConfig.class.getSimpleName(); // 登陆成功后跳转的页面
        // return LoginPageSecurityConfig.class.getSimpleName(); // 自定义登陆页面
        // return LoginProcessingUrlSecurityConfig.class.getSimpleName();// 自定义登陆接口和请求参数
        // return SuccessUrlSecuritySuccess.class.getSimpleName(); // 登陆成功跳转的URL
        // return SuccessHandlerSecuritySuccess.class.getSimpleName(); //登陆成功 Handler
        // return LoginErrorSecurityConfig.class.getSimpleName(); //登陆失败案例
    }

}
