package vip.xjdai.springbootcloudfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient
@SpringBootApplication
public class SpringbootCloudFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCloudFeignApplication.class, args);
    }

}
