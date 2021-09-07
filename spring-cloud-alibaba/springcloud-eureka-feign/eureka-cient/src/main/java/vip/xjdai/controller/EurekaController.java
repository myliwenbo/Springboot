package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EurekaController {


    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String hello(String name) {
        return name + "=============" + port;
    }
}
