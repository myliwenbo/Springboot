package vip.xjdai.springbootutils.AOPUtils.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Advice {

    @Before("execution(* vip.xjdai.springbootutils.AOPUtils.model.*Service.*(..))")
    public void advisor() {
        System.out.println("do before");
    }
}