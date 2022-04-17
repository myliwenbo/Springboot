package vip.xjdai.secunitylogin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("test")
    public String test() {
        return "需要权限才能访问";
    }
}
