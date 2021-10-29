package vip.xjdai.springbootvalue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springbootvalue.config.ContigValue;

@RestController
@RequestMapping("TestController")
public class TestController {

    @Autowired
    private ContigValue contigValue;

    @RequestMapping("test")
    public ContigValue test() {
        return contigValue.read();
    }
}
