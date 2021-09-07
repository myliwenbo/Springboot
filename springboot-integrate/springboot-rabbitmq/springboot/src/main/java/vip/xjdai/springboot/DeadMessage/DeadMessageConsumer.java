package vip.xjdai.springboot.DeadMessage;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

import java.io.IOException;

@Component
public class DeadMessageConsumer {

    /**
     * ackMode = "manual" 表示手动签收
     * @param channel
     * @param message
     * @throws IOException
     */
    @RabbitListener(queues = DeadMessageConfig.MESSAGE_QUEUE_NAME, ackMode = "manual")
    public void processMessage(Channel channel, Message message) throws IOException {
        System.out.println("one---收到消息：" + new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

    }

    @RabbitListener(queues = DeadMessageConfig.MESSAGE_QUEUE_NAME)
    public void processMessageTwo(Channel channel, Message message) throws IOException {
        try {
            //模拟消息处理失败
            int a = 3 / 0;
            // false只确认当前一个消息收到，true确认所有consumer获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        } catch (Exception e) {
            if (message.getMessageProperties().getRedelivered()) {

                System.out.println("消息已重复处理失败,拒绝再次接收...");
                try {
                    channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);//requeue为false,拒绝
                } catch (IOException e1) {
                }

            } else {

                System.out.println("消息即将再次返回队列处理...");

                try {
                    channel.basicReject(message.getMessageProperties().getDeliveryTag(), true); // requeue为true重新回到队列
                } catch (IOException e1) {
                }

            }
        }

    }
}