package vip.xjdai.ioc.annotation.c;

import org.springframework.stereotype.Service;

/**
 * @author lwb
 *
 */
@Service
public class ServiceC {

    public ServiceC() {
        System.out.println("不会创建：" + this.getClass().getPackage().getName());
    }

    public void test() {
        System.out.println("我是:" + this.getClass().getPackage() + "下的方法");
    }
}
