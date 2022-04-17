package vip.xjdai.springbootreentrantlock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("vip.xjdai.springbootreentrantlock.mapper")
@SpringBootApplication
public class SpringbootReentrantLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootReentrantLockApplication.class, args);
    }

}
