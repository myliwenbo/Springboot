package vip.xjdai.secunityauthenticationmanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sysTest")
public class SysTest {

    @RequestMapping("test1")
    public void test1() {
        System.out.println("我是p1");
    }

    @RequestMapping("test2")
    public void test2() {
        System.out.println("我是p1");
    }

    @RequestMapping("all")
    public void all() {
        System.out.println("需要P1 和 p2");
    }

    @RequestMapping("hh")
    public void hh() {
        System.out.println("不需要权限就访问，但是需要登录");
    }
}
