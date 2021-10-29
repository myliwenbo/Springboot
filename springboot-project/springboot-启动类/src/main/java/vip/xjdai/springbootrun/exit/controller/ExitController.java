package vip.xjdai.springbootrun.exit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springbootrun.exit.config.ExitConfig;

@RestController
@RequestMapping("ExitController")
public class ExitController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ExitConfig exit;

    @RequestMapping("test")
    public void test() {
        SpringApplication.exit(applicationContext, exit);
    }
}
