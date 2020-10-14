package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private SchedualServiceHi  schedualServiceHi;

    @RequestMapping("hello")
    public String helloConsumer() {
        return schedualServiceHi.sayHiFromClientOne("小明");
    }
}
