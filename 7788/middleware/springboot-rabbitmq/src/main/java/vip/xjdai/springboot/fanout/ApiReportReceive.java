package vip.xjdai.springboot.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApiReportReceive {
    @RabbitHandler
    @RabbitListener(queues = "api.report.payment")
    public void payment(String msg) {
        log.info("api.report.payment receive message: " + msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "api.report.refund")
    public void refund(String msg) {
        log.info("api.report.refund receive message: " + msg);
    }
}