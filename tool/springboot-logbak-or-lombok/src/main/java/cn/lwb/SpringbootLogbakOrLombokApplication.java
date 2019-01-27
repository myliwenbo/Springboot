package cn.lwb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.lwb.log.mybatis")
public class SpringbootLogbakOrLombokApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLogbakOrLombokApplication.class, args);
    }

}
