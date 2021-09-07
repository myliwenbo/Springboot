package vip.xjdai.springbootcloudsimpleclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringbootCloudSimpleClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCloudSimpleClientApplication.class, args);
    }

}
