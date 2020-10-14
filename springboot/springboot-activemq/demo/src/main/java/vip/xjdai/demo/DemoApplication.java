package vip.xjdai.demo;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

public class DemoApplication {

    public static void main(String[] args) throws Exception {
        // DemoApplication.send();
        DemoApplication.listener();
    }


    // 1. 创建ActiveMQConnectionFactory连接工厂，需要ActiveMQ的服务地址，使用的是tcp协议
    static String brokerURL = "tcp://192.168.117.141:61616";
    static ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(brokerURL);
    static Connection connection;
    static Session session;
    static Topic topic_test;

    static {
        try {
            // 2. 使用连接工厂创建连接
            connection = factory.createConnection();
            // 3. 使用连接对象开启连接，使用start方法
            connection.start();
            // 4. 从连接对象里获取session
            // 第一个参数的作用是，是否使用JTA分布式事务，设置为false不开启
            // 第二个参数是设置应答方式，如果第一个参数是true，那么第二个参数就失效了，这里设置的应答方式是自动应答
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // 5. 从session获取消息类型Destination，获取queue，（也可以获取topic，topic是订阅模式）
            // 参数就是设置队列名称
             topic_test = session.createTopic("topic_test");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void send() throws JMSException {
        // 6. 从session中获取消息的生产者
        MessageProducer producer = session.createProducer(topic_test);
        // 7. 创建消息体 使用TextMessage类型
        TextMessage textMessage = new ActiveMQTextMessage();
        // 设置消息的内容
        textMessage.setText("消息发送出去了");
        // 8. 使用消息的生产者发送消息
        producer.send(textMessage);
        System.out.println("发送消息成功");
        // 9. 释放资源
        producer.close();
    }

    public static void listener() throws Exception {
        // 6. 从session中获取消息的消费者
        MessageConsumer consumer = session.createConsumer(topic_test);
        // 7.接受消息
        // 使用监听器接受消息
        // 使用监听的方式接受消息，其实是创建了一个新的线程来处理消息的接受
        consumer.setMessageListener(message -> {
            // 判断消息类型是TextMessage
            if (message instanceof TextMessage) {
                // 如果是，则进行强转
                TextMessage textMessage = (TextMessage) message;
                try {
                    // 8. 消费消息，打印消息内容
                    String text = textMessage.getText();
                    System.out.println("客户端1：" + text);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // 主线程等一下，其实就是睡眠一下就可以了
        Thread.sleep(200000);
        // 9. 释放资源
        consumer.close();
    }

    public static void listenerTwo() throws Exception {
        // 6. 从session中获取消息的消费者
        MessageConsumer consumer = session.createConsumer(topic_test);
        // 7.接受消息
        // 使用监听器接受消息
        // 使用监听的方式接受消息，其实是创建了一个新的线程来处理消息的接受
        consumer.setMessageListener(message -> {
            // 判断消息类型是TextMessage
            if (message instanceof TextMessage) {
                // 如果是，则进行强转
                TextMessage textMessage = (TextMessage) message;
                try {
                    // 8. 消费消息，打印消息内容
                    String text = textMessage.getText();
                    System.out.println("客户端2：" + text);
                } catch (Exception e) {
                    //TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        // 主线程等一下，其实就是睡眠一下就可以了
        Thread.sleep(200000);
        // 9. 释放资源
        consumer.close();
    }


}