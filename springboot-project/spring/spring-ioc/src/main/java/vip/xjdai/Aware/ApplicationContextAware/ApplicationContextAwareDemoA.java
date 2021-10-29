package vip.xjdai.Aware.ApplicationContextAware;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Component
public class ApplicationContextAwareDemoA implements ApplicationContextAware {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));

    }

    public void getApplicationContext() {
        System.out.println("我执行了--------------------");
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
    }
}
