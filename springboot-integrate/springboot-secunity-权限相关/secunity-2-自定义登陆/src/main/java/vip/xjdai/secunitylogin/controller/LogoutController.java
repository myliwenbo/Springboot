package vip.xjdai.secunitylogin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LogoutController {

    @RequestMapping("logoutSuccessUrl")
    public String defaultSuccessUrl() {
        return "退出成功";
    }

}
