package vip.xjdai.utisl;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

public class MQUtils {
    private static ConnectionFactory factory;
    private static Channel           channel;

    public static Channel getMQAndChannel() {
        try {
            // 打开连接
            factory = new ConnectionFactory();
            //用户名，如果有用户名的话，可以设置，没有无需设置。
            //            factory.setUsername("admin");
            //密码，如果有用户名的话，可以设置，没有无需设置。
            //            factory.setPassword("admin");
            //端口号
            factory.setHost("192.168.6.133");
            // 设置虚拟主机
            //            factory.setVirtualHost("/");
            //端口号 注* 这里的端口是RabbitMQ的端口  不是WEB管理的端口
            factory.setPort(5672);
            // 打开频道
            com.rabbitmq.client.Connection newConnection = factory.newConnection();
            // 获取频道
            channel = newConnection.createChannel();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return channel;
    }

    public static Channel setQueueByQueueName(String queueName) {
        Channel channel = getMQAndChannel();
        //指定一个队列
        try {
            //参数1：队列名称
            //参数2：队列是否进行序列化 true(是)
            //参数3：队列是否是独占的，如果为true只能被一个connection使用，其他连接建立时会抛出异常
            //参数4：队列不再使用时是否自动删除（没有连接，并且没有未处理的消息)
            //参数5：建立队列时的其他参数
            channel.queueDeclare(queueName, false, false, false, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return channel;
    }

    public static void ColseMQAndChannel() {
        try {
            // 关闭连接和频道
            if (factory == null || channel == null) {
                return;
            }
            channel.close();
            factory.clone();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}