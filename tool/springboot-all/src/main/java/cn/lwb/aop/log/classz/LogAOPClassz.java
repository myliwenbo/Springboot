package cn.lwb.aop.log.classz;

import cn.lwb.aop.log.bag.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
