package vip.xjdai.springbootapplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootApplication {

    @Value("${myvalue.name}")
    private String name;

    public static void main(String[] args) {
        SpringApplication s = new SpringApplication(SpringbootApplication.class);
        s.setBannerMode(Banner.Mode.OFF); //会取消spring启动标识
        s.setAddCommandLineProperties(false); //禁止命令行明细
        s.setAdditionalProfiles("dev");
        ConfigurableApplicationContext run = s.run(args);
        SpringbootApplication bean = run.getBean(SpringbootApplication.class);
        System.out.println(bean.name);
    }

}
