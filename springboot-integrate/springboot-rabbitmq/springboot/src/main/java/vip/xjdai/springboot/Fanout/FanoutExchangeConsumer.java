package vip.xjdai.springboot.Fanout;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FanoutExchangeConsumer {

    @RabbitListener(queues = PublishSubscribeConfig.MESSAGE_QUEUE_NAME_ONE)
    public void processMessageOne1(Channel channel, int message) throws IOException {
        System.out.println("MESSAGE_QUEUE_NAME_ONE_1：   " + message);
    }

    @RabbitListener(queues = PublishSubscribeConfig.MESSAGE_QUEUE_NAME_TWO)
    public void processMessageOne2(int message) throws Exception {
        System.out.println("MESSAGE_QUEUE_NAME_ONE_2：   " + message);
    }
}