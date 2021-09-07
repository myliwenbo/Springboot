package vip.xjdai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


// 开启 Feign，Feign是一个声明式的伪Http客户端
@EnableFeignClients
// 开启客户端
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonFeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonFeignConsumerApplication.class, args);
    }

}
