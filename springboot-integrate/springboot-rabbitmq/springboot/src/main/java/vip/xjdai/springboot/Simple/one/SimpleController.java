package vip.xjdai.springboot.Simple.one;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springboot.Simple.SimpleRabbitConfig;

@RestController
public class SimpleController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("simple")
    public void simple() {
        for (int i = 0; i < 10; i++) {

            rabbitTemplate.convertAndSend(SimpleRabbitConfig.DIRECT_EXCHANGE_NAME, i + "");

            rabbitTemplate.setReturnCallback((Message message, int replyCode, String replyText,
                                              String exchange, String routingKey) -> {
                System.out.println("------------------------------------------------------------------------");
                System.out.println("消息主体message" + message);
                System.out.println("消息replyCode" + replyCode);
                System.out.println("消息replyText" + replyText);
                System.out.println("消息使用的交换器" + exchange);
                System.out.println("消息使用的路由键" + routingKey);
                System.out.println("------------------------------------------------------------------------");
            });

            rabbitTemplate.setConfirmCallback((CorrelationData correlationData, boolean ack, String cause) -> {
                System.out.println("------------------------------------------------------------------------");
                System.out.println("消息唯一标识" + correlationData);
                System.out.println("消息确认结果" + ack);
                System.out.println("失败原因" + cause);
                System.out.println("------------------------------------------------------------------------");
            });
        }
    }
}
