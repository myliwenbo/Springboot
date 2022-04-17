package vip.xjdai.bean.setBean;

import org.springframework.stereotype.Component;

@Component
class SetABeanDemo implements SetABeanDemoInterface {

    public SetABeanDemo() {
        System.out.println("SetABeanDemo 执行了~~~");
    }
}