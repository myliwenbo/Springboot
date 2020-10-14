package vip.xjdai.activemqclient.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService
{

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 实例
     * @param name
     * @return
     */
    @JmsListener(destination = "queue1")// 使用JmsListener配置消费者监听的队列，其中name是接收到的消息
    @SendTo("SQueue") // SendTo 会将此方法返回的数据, 写入到 OutQueue 中去.
    public String handleMessage(String name)
    {
        System.out.println("成功接受Name" + name);
        return "成功接受Name" + name;
    }

    @JmsListener(destination = "topic2")
    @SendTo("SQueue")
    public String sendMail(String name)
    {
        System.out.println("我去发送邮箱：" + name);
        return "发送邮箱为：" + name;
    }

    @JmsListener(destination = "topic2")
    @SendTo("SQueue")
    public String sendSMS(String name)
    {
        System.out.println("我去发送短信：" + name);
        return "发送短信为：" + name;
    }
}