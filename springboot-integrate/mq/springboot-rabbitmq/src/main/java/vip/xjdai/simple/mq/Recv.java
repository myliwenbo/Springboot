package vip.xjdai.simple.mq;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import vip.xjdai.utisl.MQUtils;

public class Recv {
    //队列名称
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        Channel channel = MQUtils.setQueueByQueueName(QUEUE_NAME);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) {
                String message = new String(body);
                doWork(message);
                System.out.println("Received: " + message);
                // 消息确认
                try {
                    channel.basicAck(envelope.getDeliveryTag(), false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        // 关闭自动消息确认，
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