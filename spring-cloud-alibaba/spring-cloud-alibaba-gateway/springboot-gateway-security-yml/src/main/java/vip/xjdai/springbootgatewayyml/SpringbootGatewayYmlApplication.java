package vip.xjdai.springbootgatewayyml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringbootGatewayYmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGatewayYmlApplication.class, args);
    }

}
