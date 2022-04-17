package vip.xjdai.springbootdiners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootDinersApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDinersApplication.class, args);
    }

}
