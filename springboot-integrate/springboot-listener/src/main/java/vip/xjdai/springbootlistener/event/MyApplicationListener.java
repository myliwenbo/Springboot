package vip.xjdai.springbootlistener.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener< MyEvent >
{

    //当容器中发布此事件以后，方法触发
    @Override
    public void onApplicationEvent(MyEvent event)
    {
        System.out.println("邮箱地址："+event.getAddress());
        System.out.println("邮箱内容："+event.getText());
    }



}