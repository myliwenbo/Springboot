package vip.xjdai.springboot.Direct;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springboot.Direct.DirectExchangeConfig;

@RestController
public class DirectController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/direct/index")
    public String direct() {
        for (int i = 0; i < 50; i++) {
            // // 只会发送到队列2
            // rabbitTemplate.convertAndSend(DirectExchangeConfig.DIRECT_EXCHANGE_NAME, DirectExchangeConfig.BLACK, "black");
            // // 只会发送到队列2
            // rabbitTemplate.convertAndSend(DirectExchangeConfig.DIRECT_EXCHANGE_NAME, DirectExchangeConfig.GREEN, "green");
            // 只会发送到队列1
            rabbitTemplate.convertAndSend(DirectExchangeConfig.DIRECT_EXCHANGE_NAME, DirectExchangeConfig.ORANGE, i);
        }
        return "Success";
    }



}