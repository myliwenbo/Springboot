package vip.xjdai.bean.setBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class SetBeanBDemo {

    //    @Autowired
    private SetABeanDemoInterface setABeanDemoInterface;

    public SetABeanDemoInterface getSetABeanDemoInterface() {
        return setABeanDemoInterface;
    }

    public void setSetABeanDemoInterface(SetABeanDemoInterface setABeanDemoInterface) {
        this.setABeanDemoInterface = setABeanDemoInterface;
    }
}
