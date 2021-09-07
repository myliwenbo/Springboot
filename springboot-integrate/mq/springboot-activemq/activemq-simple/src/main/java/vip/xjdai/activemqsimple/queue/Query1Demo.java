package vip.xjdai.activemqsimple.queue;

import lombok.SneakyThrows;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Query1Demo {
    public static void main(String[] args) throws Exception {
        //1、创建工厂连接对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.117.128:61616");
        //2、使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建会话（session）对象

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Queue queue = session.createQueue("test-queue");
        //6、使用会话对象创建生产者对象
        MessageConsumer consumer = session.createConsumer(queue);
        //同步消息
        new Thread(() -> synchronizeMessage(consumer)).start();
        // 异步消息
        //        new Thread(() -> asyMessage(consumer)).start();
    }

    /**
     * 同步消息
     *
     * @param consumer
     */
    @SneakyThrows
    public static void synchronizeMessage(MessageConsumer consumer) {
        Message message = consumer.receive();
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("点对点1：" + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 异步消息
     *
     * @param consumer
     */
    @SneakyThrows
    public static void asyMessage(MessageConsumer consumer) {
        //7、向consumer对象中设置一个messageListener对象，用来接收消息
        consumer.setMessageListener(message -> {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("点对点1：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
