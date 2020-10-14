package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.service.ConsumerService;

@RestController
public class ConsumerController {


    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("hello")
    public String helloConsumer() {
        return consumerService.helloConsumer();
    }

    @RequestMapping("helloHystrix")
    public String helloConsumerHystrix() {
        return consumerService.helloConsumerHystrix();
    }


}
