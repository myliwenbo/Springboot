package vip.xjdai.springbootapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("Test")
public class Test {

    public Test() {
        System.out.println("");
    }

    @Autowired
    private ConfigurableEnvironment configurableEnvironment;
 
    @RequestMapping("test")
    public void test() {
        Map<String, Object> systemProperties = configurableEnvironment.getSystemProperties();
        System.out.println(systemProperties);
    }
}