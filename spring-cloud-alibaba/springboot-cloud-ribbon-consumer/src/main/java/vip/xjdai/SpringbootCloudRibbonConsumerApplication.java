package vip.xjdai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// 通过@@EnableDiscoveryClient七注解让该应用注册为 Eureka 客户端应用， 以获得服务发现的能力。
@EnableDiscoveryClient
@SpringBootApplication
public class SpringbootCloudRibbonConsumerApplication {

    //并通过@LoadBalanced 注解开启客户端负载均衡。
    @Bean
    @LoadBalanced
    RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootCloudRibbonConsumerApplication.class, args);
    }

}
