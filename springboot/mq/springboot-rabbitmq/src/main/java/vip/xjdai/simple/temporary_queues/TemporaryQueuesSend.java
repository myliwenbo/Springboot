package vip.xjdai.simple.temporary_queues;

import com.rabbitmq.client.Channel;

import vip.xjdai.utisl.MQUtils;

/**
 * @author lwb
 *
 */
public class TemporaryQueuesSend {

    //队列名称
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        Channel channel = MQUtils.getMQAndChannel();
        //指定一个队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //这样告诉RabbitMQ不要在同一时间给一个消费者超过一条消息。换句话说，只有在消费者空闲的时候会发送下一条信息。
        channel.basicQos(1);
        //设置转发器
        //参数1: 转发器名称
        //参数2: 转发器类型
        channel.exchangeDeclare("logs", "fanout");
        channel.queueDeclare();

        for (int i = 0; i < 20; i++) {
            //发送的消息
            String message = "";
            for (int j = 0; j <= i; j++) {
                message += ".";
            }
            message += i;
            // 往队列中发出一条消息
            // 参数1: 转发器
            // 参数2: 队列名称
            // 参数3: 消息是否序列化 是(MessageProperties.PERSISTENT_TEXT_PLAIN) 否:传null值即可
            // 参数4: 转发器
            // 参数5: 要发送的信息 
            channel.basicPublish("logs", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        //关闭频道和连接
        MQUtils.ColseMQAndChannel();
    }

}
