package vip.xjdai.ioc.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vip.xjdai.ioc.annotation.a.ServiceA;
import vip.xjdai.ioc.annotation.b.ServiceB;
import vip.xjdai.ioc.annotation.c.ComponentC;
import vip.xjdai.ioc.annotation.c.RepositoryC;

@Controller
@RequestMapping("/statcitest")
public class StaticBeanInject {

    @Autowired
    private ServiceA    serviceA;

    @Autowired
    private ServiceB    serviceB;

    @Autowired
    private ComponentC  componentC;

    @Autowired
    private RepositoryC repositoryC;

    //    @Autowired
    //    private ComponentA  componentA;
    //    @Autowired
    //    private ComponentB  componentB;
    //    @Autowired
    //    private ComponentD  componentD;
    //    @Autowired
    //    private ServiceC    serviceC;
    //    @Autowired
    //    private ServiceD    serviceD;
    //    @Autowired
    //    private RepositoryD repositoryD;
    //    @Autowired
    //    private RepositoryA repositoryA;
    //    @Autowired
    //    private RepositoryB repositoryB;

    @RequestMapping("/test")
    public void test() {
        serviceA.test();
        serviceB.test();
        componentC.test();
        repositoryC.test();
        //        serviceC.test();
        //        serviceD.test();
        //        componentA.test();
        //        componentB.test();
        //        componentD.test();
        //        repositoryA.test();
        //        repositoryB.test();
        //        repositoryD.test();
    }

    /**
     * 
     */
    public StaticBeanInject() {
        System.out.println("初始化：" + this.getClass().getName());
    }
}
