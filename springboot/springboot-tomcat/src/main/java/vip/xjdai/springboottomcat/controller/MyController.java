package vip.xjdai.springboottomcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


    //设置 produces 防止中文乱码
    @GetMapping(value = "/test", produces = "application/json; charset=utf-8")
    public String test() {
        System.out.println("------MyController----------");
        return "";
    }
}