package vip.xjdai.annotation.ManagedBean;

import javax.annotation.ManagedBean;

@ManagedBean
public class ManagedBeanDemoA {

    public ManagedBeanDemoA() {
        System.out.println("我被注入了");
    }
}
