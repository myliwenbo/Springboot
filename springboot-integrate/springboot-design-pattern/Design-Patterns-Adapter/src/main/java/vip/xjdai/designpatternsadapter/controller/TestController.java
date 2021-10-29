package vip.xjdai.designpatternsadapter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("TestController")
public class TestController {

    @RequestMapping("test")
    public void test() {

    }

    @RequestMapping("test2")
    public void test2() {

    }
}
