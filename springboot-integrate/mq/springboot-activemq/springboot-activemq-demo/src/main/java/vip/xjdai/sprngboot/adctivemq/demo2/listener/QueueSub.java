package vip.xjdai.sprngboot.adctivemq.demo2.listener;

import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * 点对点..  简单来说只能是 1对1
 */
@Component
public class QueueSub {

    // 接受消息方法
    @JmsListener(destination = "queue", containerFactory = "queueListener")
    public void queueOne(ActiveMQMessage message, Session session) throws JMSException {
        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println("one接受到的消息是：" + textMessage.getText());
            // 手动确认
            // message.acknowledge();
        } catch (Exception e) {
            // 此不可省略 重发信息使用
            session.recover();
        }
    }
    // 接受消息方法
    @JmsListener(destination = "queue", containerFactory = "queueListener")
    public void queueThree(ActiveMQMessage message, Session session) throws JMSException {
        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println("3接受到的消息是：" + textMessage.getText());
            // 手动确认
            // message.acknowledge();
        } catch (Exception e) {
            // 此不可省略 重发信息使用
            session.recover();
        }
    }

    // 接受消息方法
    @JmsListener(destination = "queue", containerFactory = "queueListener")
    public void queueTwo(ActiveMQMessage message, Session session) throws JMSException {
        TextMessage textMessage = (TextMessage) message;

        try {
            // int i=1/0;
            System.out.println("one接受到的消息是：" + textMessage.getText());
            // 手动确认
            // message.acknowledge();
        } catch (Exception e) {
            // 此不可省略 重发信息使用
            session.recover();
            System.out.println("消息重发中");
        }
    }

}
