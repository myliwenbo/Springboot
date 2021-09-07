package vip.xjdai.springbootdesignpattern.proxy.dynamic;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//生产代理对象的工厂
class MyProxyFactory {

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (Object proxy, Method method, Object[] args) -> {
                    System.out.println("你大爷的");
                    //增强方法
                    method.invoke(target, args);
                    return null;
                });
    }
}