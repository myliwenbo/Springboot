package vip.xjdai.springbootvalue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springbootvalue.config.ContigValue;

import java.util.Map;

@RestController
@RequestMapping("TestController")
public class TestController {

    @Autowired
    private ContigValue contigValue;
    @Autowired
    private ConfigurableEnvironment configurableEnvironment;
    @Value("${java.runtime.name}")
    private String javaName;

    @RequestMapping(value = "test")
    public ContigValue test() {
        Map<String, Object> systemProperties = configurableEnvironment.getSystemProperties();
        // System.out.println(systemProperties);
        System.out.println(javaName);
        return contigValue.read();
    }
}
