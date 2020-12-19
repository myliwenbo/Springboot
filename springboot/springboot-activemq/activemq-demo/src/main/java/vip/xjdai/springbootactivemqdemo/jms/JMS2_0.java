package vip.xjdai.springbootactivemqdemo.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMS2_0 {
    static String brokerURL = "tcp://192.168.117.141:61616";

    public static void main(String[] args) throws JMSException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerURL);
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
        // 创建消息体
        TextMessage message = session.createTextMessage("我爱你");
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
