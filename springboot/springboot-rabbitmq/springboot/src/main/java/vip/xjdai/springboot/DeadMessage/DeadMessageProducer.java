package vip.xjdai.springboot.DeadMessage;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeadMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("sendMessage")
    public void sendMessage() {

        for (int i = 0; i < 6; i++) {
            rabbitTemplate.convertAndSend(DeadMessageConfig.MESSAGE_EXCHANGE_DL, DeadMessageConfig.MESSAGE_ROUTE_KEY_DL, "hello-----------：    " + i);
        }
    }
}