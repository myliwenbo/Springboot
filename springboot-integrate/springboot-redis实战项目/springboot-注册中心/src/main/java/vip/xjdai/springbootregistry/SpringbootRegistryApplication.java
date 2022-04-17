package vip.xjdai.springbootregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// 激活注册中心组件
@EnableEurekaServer
@SpringBootApplication
public class SpringbootRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRegistryApplication.class, args);
    }

}
