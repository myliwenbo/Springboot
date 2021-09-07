package vip.xjdai.springbootsecurity1user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("SecurityLoginSuccess")
public class SecurityLoginSuccess {

    @RequestMapping("test")
    public String test() {
        return "登陆成功";
    }
}
