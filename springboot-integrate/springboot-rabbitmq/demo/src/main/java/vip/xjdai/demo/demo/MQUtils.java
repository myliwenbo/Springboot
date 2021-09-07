package vip.xjdai.demo.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MQUtils {

    private static ConnectionFactory factory;
    private static Channel channel;

    public static Channel getMQAndChannel() {
        try {
            // 打开连接
            factory = new ConnectionFactory();
            //用户名，如果有用户名的话，可以设置，没有无需设置。
            factory.setUsername("admin");
            //密码，如果有用户名的话，可以设置，没有无需设置。
            factory.setPassword("admin");
            //地址
            factory.setHost("192.168.117.141");
            // ...
            factory.setVirtualHost("/");
            //端口号 注* 这里的端口是RabbitMQ的端口  不是WEB管理的端口
            factory.setPort(5672);
            // 打开频道
            Connection connection = factory.newConnection();
            // 获取频道
            channel = connection.createChannel();



        } catch (IOException | TimeoutException e) {
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