package vip.xjdai.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {

    @Autowired
    private RestTemplate   restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloConsumerHystrix() {
        return restTemplate.getForEntity("http://EUREKA-CLIENT/hello", String.class).getBody();
    }

    public String helloConsumer() {
        return restTemplate.getForEntity("http://EUREKA-CLIENT/hello", String.class).getBody();
    }

    public String helloFallback() {
        return "ERROR";
    }

}
