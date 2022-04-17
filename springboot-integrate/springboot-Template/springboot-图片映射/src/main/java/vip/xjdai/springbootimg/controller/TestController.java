package vip.xjdai.springbootimg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("TestController")
public class TestController {

    @RequestMapping("test")
    public String test() {
        return "is OK";
    }
}
