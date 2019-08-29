package vip.xjdai.springboot.direct;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置队列
 * @author lwb
 *
 */
@Configuration
public class DirectConfig {

    /**
     * 配置一个routingKey为notify.payment的消息队列
     * @return
     */
    @Bean
    public Queue paymentNotifyQueue() {
        return new Queue("notify.payment");
    }
}