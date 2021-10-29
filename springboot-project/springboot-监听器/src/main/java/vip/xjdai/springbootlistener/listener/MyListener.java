package vip.xjdai.springbootlistener.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import vip.xjdai.springbootlistener.event.MyEvent;

/**
 * 监听器
 */
@Component
public class MyListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("监听器1：" + event.getMessage());
    }
}
