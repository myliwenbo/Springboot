package vip.xjdai.springbootsystemconfig.controller;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("Test")
public class Test {

    @Autowired
    private ConfigurableEnvironment configurableEnvironment;

    @RequestMapping("test")
    public void test() {
        System.out.println(configurableEnvironment.getSystemEnvironment());
    }
}
