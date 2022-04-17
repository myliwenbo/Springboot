package vip.xjdai.BeanFactoryPostProcessor;

import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessorBDemo {

    public MyBeanFactoryPostProcessorBDemo() {
        System.out.println("MyBeanFactoryPostProcessorBDemo执行了");
    }
}
