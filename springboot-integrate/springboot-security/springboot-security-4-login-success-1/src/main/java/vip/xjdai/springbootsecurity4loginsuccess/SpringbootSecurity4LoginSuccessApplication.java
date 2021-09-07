package vip.xjdai.springbootsecurity4loginsuccess;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSecurity4LoginSuccessApplication {

    public static void main(String[] args) {
        SpringApplication s = new SpringApplication(SpringbootSecurity4LoginSuccessApplication.class);
        s.setBannerMode(Banner.Mode.OFF); //会取消spring启动标识
        s.setAddCommandLineProperties(false); //禁止命令行明细
        s.setAdditionalProfiles("logout"); //激活 配置文件为 dev的配置
        s.run(args);
    }

}
