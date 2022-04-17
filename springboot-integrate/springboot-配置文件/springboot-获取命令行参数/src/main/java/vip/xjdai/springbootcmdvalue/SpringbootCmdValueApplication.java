package vip.xjdai.springbootcmdvalue;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootCmdValueApplication {

    public static void main(String[] args) {
        SpringApplication s = new SpringApplication(SpringbootCmdValueApplication.class);
        s.setBannerMode(Banner.Mode.OFF); //会取消spring启动标识
        s.setAddCommandLineProperties(false); //禁止命令行参数 添加到Environment 中.. 实际测试没作用..
        s.run(args);
    }

}
