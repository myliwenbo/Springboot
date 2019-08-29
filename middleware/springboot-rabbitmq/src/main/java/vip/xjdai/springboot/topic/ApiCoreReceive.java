package vip.xjdai.springboot.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * @author lwb
 *
 */
@Component
public class ApiCoreReceive {

    /**
     * 监听routingKey为api.core的队列消息
     * @param msg
     */
    @RabbitHandler
    @RabbitListener(queues = "api.core") //队列匹配
    public void user(String msg) {
        System.out.println("api.core---收到消息：" + msg);
    }

    /**
     * 监听routingKey为api.payment的队列消息
     * @param msg
     */
    @RabbitHandler
    @RabbitListener(queues = "api.payment") //队列匹配
    public void order(String msg) {
        System.out.println("api.payment---收到消息：" + msg);
    }

}