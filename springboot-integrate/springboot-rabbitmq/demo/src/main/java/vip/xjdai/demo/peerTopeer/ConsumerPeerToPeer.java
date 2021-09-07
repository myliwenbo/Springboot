package vip.xjdai.demo.peerTopeer;

import com.rabbitmq.client.*;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import vip.xjdai.demo.demo.MQUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ConsumerPeerToPeer {
    private final static String QUEUE_NAME = "hello";

    //消费者
    public static void main(String[] argv) throws Exception {
        Channel channel = MQUtils.getMQAndChannel();
        // 设置最大服务转发消息数量        channel.basucQos(1);
        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("收到的信息:" + message);
                //开启应答机制
                // true： 关闭
                // false: 开启
                this.getChannel().basicAck(envelope.getDeliveryTag(), false);
            }
        };
        /**
         * 1.消息队列名称
         * 2.表示消费者接收到信息之后,会通知消息队列,消息队列会对该消息进行删除,
         * 3.用于处理接受到的信息
         */
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }

    public static class workQueuesOne {

        public static void main(String[] args) throws IOException {
            Channel channel = MQUtils.getMQAndChannel();
            // 创建消费者
            Consumer consumer = new DefaultConsumer(channel) {
                @SneakyThrows
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    String message = new String(body, StandardCharsets.UTF_8);
                    System.out.println("ONE收到的信息:" + message);
                    Thread.sleep(2000);
                }
            };
            /**
             * 1.消息队列名称
             * 2.表示消费者接收到信息之后,会通知消息队列,消息队列会对该消息进行删除,
             * 3.用于处理接受到的信息
             */
            channel.basicConsume(QUEUE_NAME, false, consumer);
        }
    }

    public static class workQueuesTwo {

        public static void main(String[] args) throws IOException {
            Channel channel = MQUtils.getMQAndChannel();
            // 创建消费者
            Consumer consumer = new DefaultConsumer(channel) {
                @SneakyThrows
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    String message = new String(body, StandardCharsets.UTF_8);
                    System.out.println("TWO收到的信息:" + message);
                    Thread.sleep(2000);
                }
            };
            /**
             * 1.消息队列名称
             * 2.表示消费者接收到信息之后,会通知消息队列,消息队列会对该消息进行删除,
             * 3.用于处理接受到的信息
             */
            channel.basicConsume(QUEUE_NAME, false, consumer);
        }
    }
}
