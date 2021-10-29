package vip.xjdai.secunityauthenticationmanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("NoAuthority")
public class NoAuthority {

    @RequestMapping("test")
    public void test() {
        System.out.println("不需要权限，不需要登录就能访问");

    }
}
