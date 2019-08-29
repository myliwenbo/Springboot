package vip.xjdai.springboot.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApiReportSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void generateReports(String msg) {
        log.info("api.generate.reports send message: " + msg);
        rabbitTemplate.convertAndSend("reportExchange", "api.generate.reports", msg);
    }
}