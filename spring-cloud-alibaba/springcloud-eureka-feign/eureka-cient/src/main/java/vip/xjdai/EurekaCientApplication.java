package vip.xjdai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient //服务提供者
@SpringBootApplication
public class EurekaCientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaCientApplication.class, args);
    }

}
