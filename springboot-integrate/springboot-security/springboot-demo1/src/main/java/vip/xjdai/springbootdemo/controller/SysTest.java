package vip.xjdai.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sysTest")
public class SysTest {

    @RequestMapping("test1")
    public String test() {
        return "访问成功1";
    }

    @RequestMapping("test2")
    public String test2() {
        return "访问成功2";
    }
}
