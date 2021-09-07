package vip.xjdai.springboot.Fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springboot.Direct.DirectExchangeConfig;

@RestController
public class FanoutController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/fanout/index")
    public String fanout() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend(PublishSubscribeConfig.DIRECT_EXCHANGE_NAME, DirectExchangeConfig.BLACK, i);
        }
        return "Success";
    }
}
