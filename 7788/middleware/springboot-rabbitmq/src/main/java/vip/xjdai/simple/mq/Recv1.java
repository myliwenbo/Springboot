package vip.xjdai.simple.mq;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import vip.xjdai.utisl.MQUtils;

public class Recv1 {
    //队列名称
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        Channel channel = MQUtils.getMQAndChannel();
        //声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) {
                String message = new String(body);
                doWork(message);
                System.out.println("Received1.2: " + message);
                // 消息确认
                try {
                    channel.basicAck(envelope.getDeliveryTag(), false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        // 关闭自动消息确认，autoAck = false
        channel.basicConsume(QUEUE_NAME, false, consumer);

    }

    /**
     * @param message
     * @throws InterruptedException 
     */
    protected static void doWork(String message) {
        try {
            for (char ch : message.toCharArray()) {
                if (ch == '.')
                    Thread.sleep(900);
            }

        } catch (Exception e) {
            System.out.println("aaa");
        }
    }
}