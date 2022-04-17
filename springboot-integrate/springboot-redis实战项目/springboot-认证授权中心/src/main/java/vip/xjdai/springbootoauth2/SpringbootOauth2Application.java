package vip.xjdai.springbootoauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vip.xjdai.springbootoauth2.config.AuthorizationServerConfiguration;

import java.lang.reflect.Method;


@MapperScan("vip.xjdai.springbootoauth2.mapper")
@SpringBootApplication
public class SpringbootOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootOauth2Application.class, args);
    }

}
