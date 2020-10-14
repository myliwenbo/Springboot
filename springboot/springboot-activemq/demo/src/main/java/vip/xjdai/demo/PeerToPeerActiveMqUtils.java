package vip.xjdai.demo;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

public class PeerToPeerActiveMqUtils {


    public static void main(String[] args) throws Exception {
        // PeerToPeerActiveMqUtils.send();
        // PeerToPeerActiveMqUtils.listener();
        // PeerToPeerActiveMqUtils.listenerTwo();
        PeerToPeerActiveMqUtils.dianDuiDian();
    }


    // 1. 创建ActiveMQConnectionFactory连接工厂，需要ActiveMQ的服务地址，使用的是tcp协议
    static String brokerURL = "tcp://192.168.117.141:61616";
    static ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(brokerURL);
    static Connection connection;
    static Session session;
    static Queue queue;

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
            queue = session.createQueue("queue");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void send() throws Exception {
        // 6. 从session中获取消息的生产者
        MessageProducer producer = session.createProducer(queue);
        // 7. 创建消息体 使用TextMessage类型
        TextMessage textMessage = new ActiveMQTextMessage();
        // 设置消息的内容
        textMessage.setText("AAAA");
        // 8. 使用消息的生产者发送消息
        producer.send(textMessage);
        System.out.println("消息发送成功");
        // 9. 释放资源
        producer.close();

    }

    public static void listener() throws Exception {
        // 6. 从session中获取消息的消费者
        MessageConsumer consumer = session.createConsumer(queue);
        // 7. 使用监听器接收消息
        // 使用监听的方式接收消息，其实是创建了一个新的线程来处理消息的接收
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
        Thread.sleep(10000);
        // 9. 释放资源
        consumer.close();
    }

    public static void listenerTwo() throws Exception {
        // 6. 从session中获取消息的消费者
        MessageConsumer consumer = session.createConsumer(queue);
        // 7. 使用监听器接收消息
        // 使用监听的方式接收消息，其实是创建了一个新的线程来处理消息的接收
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
                    e.printStackTrace();
                }
            }
        });
        // 主线程等一下，其实就是睡眠一下就可以了
        Thread.sleep(10000);
        // 9. 释放资源
        consumer.close();
    }


    public static void dianDuiDian() throws JMSException {
        // 6. 从session中获取消息的消费者
        MessageConsumer consumer = session.createConsumer(queue);
        // 7.接受消息
        while (true) {
            // 参数表示接受消息等待的时间，单位是毫秒
            Message message = consumer.receive(200000L);
            // 如果没有消息则跳出循环
            if (message == null) {
                break;
            }
            // 判断消息类型是TextMessage
            if (message instanceof TextMessage) {
                // 如果是，则进行强转
                TextMessage textMessage = (TextMessage) message;
                // 8. 消费消息，打印消息内容
                System.out.println(textMessage.getText());
                break;
            }
        }

        // 9. 释放资源
        consumer.close();
    }
}
