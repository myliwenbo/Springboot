package vip.xjdai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("vip.xjdai")
@SpringBootApplication
public class SpringbootReadWriteSeparationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootReadWriteSeparationApplication.class, args);
    }

}
