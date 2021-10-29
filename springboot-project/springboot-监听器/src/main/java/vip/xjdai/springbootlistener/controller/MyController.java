package vip.xjdai.springbootlistener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springbootlistener.event.MyEvent;

@RestController
@RequestMapping("MyController")
public class MyController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("test")
    public void test() {
        for (int i = 0; i < 100; i++) {
            applicationContext.publishEvent(new MyEvent("嘿嘿嘿"));
        }

    }
}
