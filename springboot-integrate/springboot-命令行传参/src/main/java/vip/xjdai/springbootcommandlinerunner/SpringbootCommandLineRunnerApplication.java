package vip.xjdai.springbootcommandlinerunner;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import vip.xjdai.springbootcommandlinerunner.config.MyBean;

import java.util.Arrays;

@Data
@SpringBootApplication
public class SpringbootCommandLineRunnerApplication {


    @Value("${Myname}")
    private String value;


    public static void main(String[] args) {
        System.out.println("main方法：" + Arrays.toString(args));
        SpringApplication value = new SpringApplication(SpringbootCommandLineRunnerApplication.class);
        value.setAddCommandLineProperties(true); //禁止命令行
        ConfigurableApplicationContext run = value.run(args);
        System.out.println(run.getBean(SpringbootCommandLineRunnerApplication.class).getValue());
    }


}
