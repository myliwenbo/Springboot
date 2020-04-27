package vip.xjdai.springbootlistener.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springbootlistener.event.MyEvent;

@RestController
@RequestMapping("event")
public class EventController
{

    @GetMapping("event")
    public void event()
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //发布事件；
        applicationContext.publishEvent(new MyEvent(new String("我发布的时间"),"123@123","123123"));
        applicationContext.close();
    }
}
