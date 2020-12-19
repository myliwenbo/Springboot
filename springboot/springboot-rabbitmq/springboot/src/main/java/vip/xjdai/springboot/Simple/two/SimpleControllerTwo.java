package vip.xjdai.springboot.Simple.two;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springboot.Simple.SimpleRabbitConfig;

@RestController
public class SimpleControllerTwo {
 
    @Autowired
    private RabbitTemplate rabbitTemplate;
 
    @RequestMapping("/simple/two")
    public void simple() {
        for (int i = 0; i < 50; i++) {
            rabbitTemplate.convertAndSend(SimpleRabbitConfig.DIRECT_EXCHANGE_NAME_TWO, i + "");
        }
    }
}
 