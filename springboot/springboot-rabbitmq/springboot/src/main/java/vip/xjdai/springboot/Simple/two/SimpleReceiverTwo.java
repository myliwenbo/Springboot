package vip.xjdai.springboot.Simple.two;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import vip.xjdai.springboot.Simple.SimpleRabbitConfig;

import java.io.IOException;

@Component
public class SimpleReceiverTwo {


    @RabbitListener(queues = SimpleRabbitConfig.DIRECT_EXCHANGE_NAME_TWO)
    public void receiveOne(int in) {
        System.out.println(" [1] Received '{" + in + "}'");
    }


    @RabbitListener(queues = SimpleRabbitConfig.DIRECT_EXCHANGE_NAME_TWO)
    public void receiveTwo(int in) {
        System.out.println(" [2] Received '{" + in + "}'");
    }
}