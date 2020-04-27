package vip.xjdai.springboot.headers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ApiCreditReceive {
    @RabbitHandler
    @RabbitListener(queues = "credit.bank")
    public void creditBank(String msg) {
        System.out.println("收到消息：" + msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "credit.finance")
    public void creditFinance(String msg) {
        System.out.println("收到消息：" + msg);

    }
}