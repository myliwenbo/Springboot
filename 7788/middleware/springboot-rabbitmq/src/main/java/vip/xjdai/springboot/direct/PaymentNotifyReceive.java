package vip.xjdai.springboot.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * @author lwb
 *
 */
@Component
//queues=队列名称
@RabbitListener(queues = "notify.payment")
public class PaymentNotifyReceive {

    /**
     * 监听routingKey为notify.payment的队列消息
     * @param msg
     */
    @RabbitHandler
    public void receive(String msg) {
        System.out.println("收到：" + msg);
    }
}