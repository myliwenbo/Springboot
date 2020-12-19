package vip.xjdai.springboot.Direct;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DirectExchangeConsumer {

    private Integer count = 0;

    // 采用同一个队列，会采用负载的方式 进行 调用..
    // 可能会调用 processMessageOne1 或者  processMessageOne2
    //---------------------------------------------------------------------------------------------
    @RabbitListener(queues = DirectExchangeConfig.MESSAGE_QUEUE_NAME_ONE)
    public void processMessageOne1(Channel channel, int message) throws IOException {
        count += 1;
        System.out.println("MESSAGE_QUEUE_NAME_ONE_1：   " + message);
        System.out.println(count);
    }

    @RabbitListener(queues = DirectExchangeConfig.MESSAGE_QUEUE_NAME_ONE)
    public void processMessageOne2(int message) throws Exception {
        try {
            int i = 1 / 0;
            System.out.println("MESSAGE_QUEUE_NAME_ONE_2：   " + message);
        } catch (Exception e) {

        }

    }

    //---------------------------------------------------------------------------------------------
    // @RabbitListener(queues = DirectExchangeConfig.MESSAGE_QUEUE_NAME_TWO)
    // public void processMessageTwo1(Message message) throws Exception {
    //     System.out.println("MESSAGE_QUEUE_NAME_TWO_1：   " + new String(message.getBody()));
    // }
    //
    // @RabbitListener(queues = DirectExchangeConfig.MESSAGE_QUEUE_NAME_TWO)
    // public void processMessageTwo2(Message message) throws Exception {
    //     System.out.println("MESSAGE_QUEUE_NAME_TWO_2：   " + new String(message.getBody()));
    // }
}