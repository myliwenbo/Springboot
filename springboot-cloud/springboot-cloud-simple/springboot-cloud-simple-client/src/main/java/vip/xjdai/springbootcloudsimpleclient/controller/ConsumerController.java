package vip.xjdai.springbootcloudsimpleclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    // 获取微服务的清单
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("hello")
    public String helloConsumer() {
        //这里的地址是服务提供者的地址
        ServiceInstance serviceInstance = discoveryClient.getInstances("eureka-service").get(0);
        System.out.println("获取端口：" + serviceInstance.getPort());
        System.out.println("获取Url：" + serviceInstance.getUri());
        System.out.println("获取IP：" + serviceInstance.getHost());
        System.out.println("获取ServiceId：" + serviceInstance.getServiceId());

        return restTemplate.getForEntity(serviceInstance.getUri() + "/hello/", String.class).getBody();
    }
}