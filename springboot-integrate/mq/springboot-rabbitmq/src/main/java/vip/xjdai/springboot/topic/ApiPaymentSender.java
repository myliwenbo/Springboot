package vip.xjdai.springboot.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 * @author lwb
 *
 */
@Component
public class ApiPaymentSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void user(String msg) {
        System.out.print("队列为：api.core.user");
        System.out.print("转换器为：coreExchange");
        System.out.println("发送：" + msg);
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user", msg);
    }

    public void userQuery(String msg) {
        System.out.print("队列为：api.core.user.query");
        System.out.print("转换器为：coreExchange");
        System.out.println("发送：" + msg);
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user.query", msg);
    }

    public void order(String msg) {
        System.out.print("队列为：api.payment.order");
        System.out.print("转换器为：paymentExchange");
        System.out.println("发送：" + msg);
        rabbitTemplate.convertAndSend("paymentExchange", "api.payment.order", msg);
    }

    public void orderQuery(String msg) {
        System.out.print("队列为：api.payment.order.query");
        System.out.print("转换器为：paymentExchange");
        System.out.println("发送：" + msg);
        rabbitTemplate.convertAndSend("paymentExchange", "api.payment.order.query", msg);
    }

    public void orderDetailQuery(String msg) {
        System.out.print("队列为：api.payment.order.detail.query");
        System.out.print("转换器为：paymentExchange");
        System.out.println("发送：" + msg);
        rabbitTemplate.convertAndSend("paymentExchange", "api.payment.order.detail.query",
            msg);
    }

}