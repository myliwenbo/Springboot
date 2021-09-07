package vip.xjdai;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient //客户端
public class EurekaCientApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(EurekaCientApplication.class, args);

    }

}
