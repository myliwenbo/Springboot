package vip.xjdai.activemqsimple.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class SubDemo {

    public static void main(String[] args) throws Exception {
        SubDemo.sub1();
        SubDemo.sub2();
        //8、程序等待接收用户消息
        System.in.read();
    }

    private static void sub2() throws Exception {
        //1、创建工厂连接对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.117.128:61616");
        //2、使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建会话（session）对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Topic topic = session.createTopic("test-topic");
        //6、使用会话对象创建生产者对象
        MessageConsumer consumer = session.createConsumer(topic);
        //7、向consumer对象中设置一个messageListener对象，用来接收消息
        consumer.setMessageListener(message -> {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("订阅1：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public static void sub1() throws Exception {
        //1、创建工厂连接对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.117.128:61616");
        //2、使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建会话（session）对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Topic topic = session.createTopic("test-topic");
        //6、使用会话对象创建生产者对象
        MessageConsumer consumer = session.createConsumer(topic);
        //7、向consumer对象中设置一个messageListener对象，用来接收消息
        consumer.setMessageListener(message -> {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("订阅2：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void close(MessageConsumer consumer, Session session, Connection connection) throws JMSException {
        //9、关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
