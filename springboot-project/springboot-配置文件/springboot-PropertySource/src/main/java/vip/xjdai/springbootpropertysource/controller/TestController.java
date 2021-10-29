package vip.xjdai.springbootpropertysource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springbootpropertysource.config.ConfigPropertySource;

@RestController
@RequestMapping("TestController")
public class TestController {

    @Autowired
    private ConfigPropertySource configPropertySource;

    @RequestMapping("test")
    public String test() {
        return configPropertySource.getName();
    }
}
