package vip.xjdai.springbootcloudsimpleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaClient //服务提供者
@SpringBootApplication
public class SpringbootCloudSimpleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCloudSimpleServiceApplication.class, args);
    }

}
