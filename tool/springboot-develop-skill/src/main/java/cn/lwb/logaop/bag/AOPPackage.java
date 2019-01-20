package cn.lwb.logaop.bag;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aop/package")
public class AOPPackage {

    @RequestMapping("aop")
    public String logAOPClass(String name) {
        return name;
    }
}
