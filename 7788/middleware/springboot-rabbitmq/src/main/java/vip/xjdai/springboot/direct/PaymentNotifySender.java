package vip.xjdai.springboot.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产者
 * @author lwb
 *
 */
@Component
public class PaymentNotifySender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 添加一个消息发送类（生产者）
     * @param msg
     */
    public void sender(String msg) {
        System.out.println("发送消息：" + msg);
        /**
         * 参数1：队列名称
         * 参数2：消息
         */
        rabbitTemplate.convertAndSend("notify.payment", msg);
    }
}