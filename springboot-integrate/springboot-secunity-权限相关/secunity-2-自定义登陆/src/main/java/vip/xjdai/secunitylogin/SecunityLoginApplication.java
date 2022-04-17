package vip.xjdai.secunitylogin;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vip.xjdai.secunitylogin.config.SecurityConfig;

@SpringBootApplication
public class SecunityLoginApplication {

    public static void main(String[] args) {
        SpringApplication s = new SpringApplication(SecunityLoginApplication.class);
        s.setBannerMode(Banner.Mode.OFF); //会取消spring启动标识
        s.setAddCommandLineProperties(false); //禁止命令行明细
        s.setAdditionalProfiles(SecurityConfig.getProfile()); //激活 配置文件为 dev的配置
        s.run(args);
    }

}
