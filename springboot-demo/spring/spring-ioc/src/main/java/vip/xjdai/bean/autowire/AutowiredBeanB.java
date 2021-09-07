package vip.xjdai.bean.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredBeanB {

    @Autowired
    private AutowiredBeanA autowiredBeanA;

    public AutowiredBeanA getAutowiredBeanA() {
        return autowiredBeanA;
    }
}
