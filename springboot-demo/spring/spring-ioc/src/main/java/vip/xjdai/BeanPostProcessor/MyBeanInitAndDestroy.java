package vip.xjdai.BeanPostProcessor;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyBeanInitAndDestroy {

    @PostConstruct
    public void init() {
//        System.out.println("init方法执行了");
    }

}
