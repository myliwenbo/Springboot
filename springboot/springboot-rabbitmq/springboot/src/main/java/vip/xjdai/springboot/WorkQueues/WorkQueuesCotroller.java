package vip.xjdai.springboot.WorkQueues;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkQueuesCotroller {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RequestMapping("workQueues")
    public void workQueues() {
        for (int i = 0; i < 10; i++) {
            // 发送消息..
            rabbitTemplate.convertAndSend(WorkQueuesExchangeConfig.MESSAGE_QUEUE_NAME_ONE, i + "");
            //
            rabbitTemplate.setReturnCallback((Message message, int replyCode, String replyText,
                                              String exchange, String routingKey) -> {
                System.out.println("消息主体message" + message);
                System.out.println("消息replyCode" + replyCode);
                System.out.println("消息replyText" + replyText);
                System.out.println("消息使用的交换器" + exchange);
                System.out.println("消息使用的路由键" + routingKey);
            });
        }
    }
}
