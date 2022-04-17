package vip.xjdai.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredBeanDemoA {

    private AutowiredBeanDemoB autowiredBeanDemoB;

    public AutowiredBeanDemoB getAutowiredBeanDemoB() {
        return autowiredBeanDemoB;
    }

    public void setAutowiredBeanDemoB(AutowiredBeanDemoB autowiredBeanDemoB) {
        this.autowiredBeanDemoB = autowiredBeanDemoB;
    }

//    public void getSout(){
//        System.out.println(autowiredBeanDemoB);
//    }
}
