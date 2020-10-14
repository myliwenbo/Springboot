package vip.xjdai.listener;

import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

@Component
public class TopicSub {

    @JmsListener(destination = "video.topic", containerFactory = "topicListener")
    public void receive1(ActiveMQMessage message, Session session) throws JMSException {
        TextMessage textMessage = (TextMessage) message;

        try {
            int i = 1 / 0;
            System.out.println("1：" + textMessage.getText());
            // 手动确认
            message.acknowledge();
        } catch (Exception e) {
            // 此不可省略 重发信息使用
            System.out.println("重新调用中...");
            session.recover();
        }
    }

    @JmsListener(destination = "video.topic", containerFactory = "topicListener")
    public void receive2(ActiveMQMessage message, Session session) throws JMSException {
        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println("2：" + textMessage.getText());
            // 手动确认
            message.acknowledge();
        } catch (Exception e) {
            // 此不可省略 重发信息使用
            session.recover();
        }
    }

    @JmsListener(destination = "video.topic", containerFactory = "topicListener")
    public void receive3(ActiveMQMessage message, Session session) throws JMSException {
        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println("3：" + textMessage.getText());
            // 手动确认
            message.acknowledge();
        } catch (Exception e) {
            // 此不可省略 重发信息使用
            session.recover();
        }
    }
}