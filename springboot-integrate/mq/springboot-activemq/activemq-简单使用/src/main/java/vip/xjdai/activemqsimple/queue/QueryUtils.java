package vip.xjdai.activemqsimple.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueryUtils {
    public static final String BROKERURL = "tcp://192.168.117.129:61616";

    /**
     * 获取连接...
     *
     * @return
     * @throws JMSException
     */
    public static Connection getConnection() throws JMSException {
        //1、创建工厂连接对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKERURL);
        //2、使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
        return connection;
    }

    /**
     * 获取session
     *
     * @return
     * @throws JMSException
     */
    public static Session getSession() throws JMSException {
        Connection connection = getConnection();
        // 是否支持事物：false 不支持， true 支持
        // 当 为true 的时候 ，应答模式是被忽略的，也就是说应答模式只有 不是事物的情况下才有作用
        // Session.AUTO_ACKNOWLEDGE： 为自动确认，当客户成功的从receive方法返回的时候，或者从 MessageListener.onMessage方法成功返回的时候，会话自动确认客户收到的消息。
        // Session.CLIENT_ACKNOWLEDGE： 为客户端确认。客户端接收到消息后，必须调用javax.jms.Message的acknowledge方法。jms服务器才会删除消息。（默认是批量确认）
        // Session.DUPS_OK_ACKNOWLEDGE： 允许副本的确认模式。一旦接收方应用程序的方法调用从处理消息处返回，会话对象就会确认消息的接收，而且允许重复确认。
        //                              如果是重复的消息，那么JMS provider必须把消息头的JMSRedelivered字段设置为true。
        return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }


    public static void sendMessage() throws JMSException {
        Session session = QueryUtils.getSession();
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Queue queue = session.createQueue("test-queue");
        //6、使用会话对象创建生产者对象
        MessageProducer producer = session.createProducer(queue);
        for (int i = 0; i < 100; i++) {
            //7、使用会话对象创建一个消息对象
            TextMessage textMessage = session.createTextMessage("消息索引：" + i);
            //8、发送消息
            producer.send(textMessage);
        }
    }
}
