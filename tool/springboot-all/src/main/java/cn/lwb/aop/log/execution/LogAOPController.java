package cn.lwb.aop.log.execution;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aop")
public class LogAOPController {

    @RequestMapping("aop")
    public String aopDemo(String name) {
        return name;
    }

    @RequestMapping("message")
    public String message(String name) {
        return name;
    }
}
