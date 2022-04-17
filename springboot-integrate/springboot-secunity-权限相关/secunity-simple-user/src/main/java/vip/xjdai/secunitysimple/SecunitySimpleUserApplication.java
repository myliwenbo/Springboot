package vip.xjdai.secunitysimple;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import vip.xjdai.secunitysimple.config.SecunityConfig;

@SpringBootApplication
public class SecunitySimpleUserApplication {

    public static void main(String[] args) {
        SpringApplication s = new SpringApplication(SecunitySimpleUserApplication.class);
        s.setBannerMode(Banner.Mode.OFF); //会取消spring启动标识
        s.setAddCommandLineProperties(false); //禁止命令行明细
        s.setAdditionalProfiles(SecunityConfig.profile); //激活 配置文件为 dev的配置
        s.run(args);


    }
}

