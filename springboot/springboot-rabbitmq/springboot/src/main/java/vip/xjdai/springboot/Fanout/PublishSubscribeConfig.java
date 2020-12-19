package vip.xjdai.springboot.Fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//发布订阅模式的配置
@Configuration
public class PublishSubscribeConfig {

    public static String DIRECT_EXCHANGE_NAME = "fanout";

    // 消息队列名称
    public final static String MESSAGE_QUEUE_NAME_ONE = "queue1";
    public final static String MESSAGE_QUEUE_NAME_TWO = "queue2";

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(DIRECT_EXCHANGE_NAME);
    }

    @Bean
    public Queue myQueue1() {
        return new Queue(MESSAGE_QUEUE_NAME_ONE);
    }

    @Bean
    public Queue myQueue2() {
        return new Queue(MESSAGE_QUEUE_NAME_TWO);
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(myQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(myQueue2()).to(fanoutExchange());
    }

}