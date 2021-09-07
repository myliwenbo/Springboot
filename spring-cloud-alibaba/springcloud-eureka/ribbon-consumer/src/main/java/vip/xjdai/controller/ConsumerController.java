package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("hello")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://127.0.0.1:8081/hello", String.class).getBody();
    }
}
