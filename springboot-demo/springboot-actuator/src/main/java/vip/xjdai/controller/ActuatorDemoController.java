package vip.xjdai.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class ActuatorDemoController {

    @RequestMapping("test")
    public String test() {
        return "ok";
    }
}
