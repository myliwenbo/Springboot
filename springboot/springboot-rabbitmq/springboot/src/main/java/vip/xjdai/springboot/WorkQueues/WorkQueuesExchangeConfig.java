package vip.xjdai.springboot.WorkQueues;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 不需要绑定任何.. 就是简单的队列.
 */
@Configuration
public class WorkQueuesExchangeConfig {

    // 消息队列名称
    public final static String MESSAGE_QUEUE_NAME_ONE = "WorkQueues.1";

    @Bean
    public Queue workQueuesExchangeConfigQueue1() {
        return new Queue(WorkQueuesExchangeConfig.MESSAGE_QUEUE_NAME_ONE);
    }
}

