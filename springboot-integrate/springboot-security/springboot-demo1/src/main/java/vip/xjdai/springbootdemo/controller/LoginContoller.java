package vip.xjdai.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("loginContoller")
public class LoginContoller {

    @RequestMapping("/test")
    public String test() {
        return "登陆成功";
    }
}
