package vip.xjdai.springboot.Simple.one;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import vip.xjdai.springboot.Simple.SimpleRabbitConfig;

import java.io.IOException;

@Component
public class SimpleReceiver {


    @RabbitListener(queues = SimpleRabbitConfig.DIRECT_EXCHANGE_NAME)
    public void receiveOne(Channel channel, Message message) throws IOException {

        try {
            //模拟消息处理失败
            int a = 3 / 0;
            // false只确认当前一个消息收到，
            // true确认所有 consumer 获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            if (message.getMessageProperties().getRedelivered()) {
                // 针对当前消息拒绝
                //requeue为false,拒绝
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), true); // requeue为true重新回到队列
                // 拒绝多条消息
                // channel.basicNack();
            }

        }

    }
}