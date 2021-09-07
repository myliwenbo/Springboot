package vip.xjdai.springboot.WorkQueues;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import vip.xjdai.springboot.Simple.SimpleRabbitConfig;
import vip.xjdai.springboot.WorkQueues.WorkQueuesExchangeConfig;

import java.io.IOException;

/**
 * 工作队列
 */
@Component
public class WorkQueuesConsumer {

    // 采用同一个队列，
    // 可能会调用 processMessageOne1 或者  processMessageOne2
    //---------------------------------------------------------------------------------------------
    @RabbitListener(queues = WorkQueuesExchangeConfig.MESSAGE_QUEUE_NAME_ONE)
    public void receiveOne(Channel channel, Message message) throws IOException {
        System.out.println(" [1] Received '{" + new String(message.getBody()) + "}'");
        //模拟消息处理失败
        try {
            int a = 3 / 0;
            // false 只确认当前一个消息收到，
            // true 确认所有 consumer 获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }catch (Exception e){
            System.out.println("出现异常");
        }

    }


    @RabbitListener(queues = WorkQueuesExchangeConfig.MESSAGE_QUEUE_NAME_ONE)
    public void receiveTwo(String in) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(" [2] Received '{" + in + "}'");
    }
}