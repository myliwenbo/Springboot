package vip.xjdai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient //客户端
public class EurekaCientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaCientApplication.class, args);
    }

}
