package cn.lwb.aop.log.classz;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apo/classz")
public class LogAOPClassz {

    @RequestMapping("aop")
    public String logAOPClass(String name) {
        return name;
    }
}
