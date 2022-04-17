package vip.xjdai.springbootcontrolleradvice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class Controller {

    @GetMapping(value = "/str", produces = "application/json; charset=utf-8")
    public String fun1() {
        return LocalDateTime.now().toString();
    }

    @GetMapping("/long")
    public Long fun2() {
        return System.currentTimeMillis();
    }
}