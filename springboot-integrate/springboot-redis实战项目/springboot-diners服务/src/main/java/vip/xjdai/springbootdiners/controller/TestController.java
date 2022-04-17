package vip.xjdai.springbootdiners.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("TestController")
public class TestController {

    @GetMapping("test")
    public String test(String value) {
        return "hello" + value;
    }
}
