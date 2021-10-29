package vip.xjdai.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PostConstructBeanDemoA  implements InitializingBean {

    @PostConstruct
    public void init() {
        System.out.println("第一次");

    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第二次");
    }
}
