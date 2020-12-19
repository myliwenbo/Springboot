package vip.xjdai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//Spring boot方式
@EnableTransactionManagement
@SpringBootApplication
public class SpringbootMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMysqlApplication.class, args);
    }

}
