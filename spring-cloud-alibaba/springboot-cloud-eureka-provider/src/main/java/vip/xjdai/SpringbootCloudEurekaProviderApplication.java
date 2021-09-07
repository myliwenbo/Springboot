package vip.xjdai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringbootCloudEurekaProviderApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootCloudEurekaProviderApplication.class, args);
    }

}
