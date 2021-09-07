package vip.xjdai.springbootspringutils.ClassUtils.getUserClass;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;


public class getUserClass {

    @Test
    public void getUserClass1() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyIServiceImpl.class);
        enhancer.setCallback((InvocationHandler) (o, method, objects) -> {
            System.out.println("准备场地");
            System.out.println("准备设备");
            //增强方法
            method.invoke(o, objects);
            System.out.println("收拾场地");
            return o;
        });
        ProxyIServiceImpl o = (ProxyIServiceImpl) enhancer.create();

        System.out.println(ClassUtils.getUserClass(o));
        System.out.println(o.getClass().getName());

    }
}



