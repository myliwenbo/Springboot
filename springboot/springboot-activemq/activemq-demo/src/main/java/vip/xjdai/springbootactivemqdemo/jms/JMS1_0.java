package vip.xjdai.springbootactivemqdemo.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.junit.jupiter.api.Test;

import javax.jms.*;

public class JMS1_0 {
    static String brokerURL = "tcp://192.168.117.141:61616";

    @Test
    public void one() throws Exception {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerURL);
        ActiveMQTextMessage message = new ActiveMQTextMessage();
        message.setText("我爱你");
        sendMessageJMSl(connectionFactory, message);
    }

    // 创建连接工厂
    public void sendMessageJMSl(ConnectionFactory connectionFactory, TextMessage message) throws Exception {
        // 获取连接
        Connection connection = connectionFactory.createConnection();
        // 启动
        connection.start();
        // 创建会话
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        // 创建队列
        Queue test_queue = session.createQueue("test_queue");
        // 创建生产者
        MessageProducer producer = session.createProducer(test_queue);
        // 发送消息
        producer.send(message);
        // 提交事物
        session.commit();
        // 关闭资源
        session.close();
        // 关闭资源
        connection.close();

    }
}
