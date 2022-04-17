package vip.xjdai.springbootgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGatewayApplication.class, args);
    }

}
