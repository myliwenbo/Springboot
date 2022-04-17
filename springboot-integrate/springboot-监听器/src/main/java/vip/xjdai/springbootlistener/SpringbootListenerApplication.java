package vip.xjdai.springbootlistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import vip.xjdai.springbootlistener.event.MyEvent;
import vip.xjdai.springbootlistener.listener.MyListener;
import vip.xjdai.springbootlistener.listener.MyListener2;

@SpringBootApplication
public class SpringbootListenerApplication {

    public static void main(String[] args) {
        SpringApplication value = new SpringApplication(SpringbootListenerApplication.class);
        value.addListeners(new MyListener2()); // 手动添加监听器
        value.addListeners((ApplicationListener<MyEvent>) event -> {
            System.out.println("我是拦截器3：" + event.getMessage());
        });
        ConfigurableApplicationContext run = value.run(args);
    }

}
