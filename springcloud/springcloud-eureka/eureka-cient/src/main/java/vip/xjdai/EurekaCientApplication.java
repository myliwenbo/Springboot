package vip.xjdai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient //客户端
@SpringBootApplication
public class EurekaCientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaCientApplication.class, args);
    }

}
