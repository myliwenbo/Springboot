package vip.xjdai.sprngboot.adctivemq.demo.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Topic;

@RestController("send")
public class SendDemo {

    //注入存放消息的队列，用于下列方法一
    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    //注入springboot封装的工具类
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    @RequestMapping("sendQueue")
    public String sendQueue(String name) throws JMSException {
        // TextMessage textMessage = new ActiveMQTextMessage();
        // textMessage.setStringProperty("key", "value");
        // jmsMessagingTemplate.convertAndSend(queue, textMessage);
        //添加消息到消息队列
        jmsMessagingTemplate.convertAndSend(queue, name);
        return "你好";
    }

    @RequestMapping("sendTopic")
    public String sendTopic(String name) {
        //添加消息到消息队列
        jmsMessagingTemplate.convertAndSend(topic, name);
        return "你好";
    }
}
