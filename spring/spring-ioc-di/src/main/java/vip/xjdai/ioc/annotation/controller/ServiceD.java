package vip.xjdai.ioc.annotation.controller;

import org.springframework.stereotype.Service;

/**
 * @author lwb
 *
 */
@Service
public class ServiceD {

    public ServiceD() {
        System.out.println("不会创建：" + StaticBeanInject.class.getPackage().getName());
    }

    public void test() {
        System.out.println("我是:" + this.getClass().getPackage() + "下的方法");
    }
}
