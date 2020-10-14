package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ConsumerController {

    @Autowired
    private SchedualService schedualService;

    @RequestMapping("hello")
    public String helloConsumer() {
        return schedualService.sayHiFromClientOne("hello");
    }



    @Autowired
    private SchedualServiceTwo  schedualServiceTwo;

    @RequestMapping("helloTwo")
    public String helloConsumerTwo() {
        return schedualServiceTwo.sayHiFromClientOne("helloTwo");
    }
}
