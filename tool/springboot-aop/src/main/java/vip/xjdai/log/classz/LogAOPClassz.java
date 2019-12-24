package vip.xjdai.log.classz;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.log.bag.ApiOperation;

@RestController
@RequestMapping("apo/classz")
public class LogAOPClassz
{

    @RequestMapping("aop")
    @ApiOperation(value = "住院病人信息")
    public String logAOPClass()
    {
        System.out.println("rizh ");
        return "ok";
    }
}
