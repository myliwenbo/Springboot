package vip.xjdai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//注册到服务中心
@EnableEurekaServer
@EnableConfigServer
@SpringBootApplication
public class SpringbootCloudConfigApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootCloudConfigApplication.class, args);
    }

}
