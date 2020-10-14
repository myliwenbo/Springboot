package vip.xjdai;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
//开启熔断
@EnableHystrix
//开启Hystrix网页调试
@EnableHystrixDashboard
// 开启 Feign，Feign是一个声明式的伪Http客户端
@EnableFeignClients
public class FeignHystrixConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixConsumerApplication.class, args);
    }

}
