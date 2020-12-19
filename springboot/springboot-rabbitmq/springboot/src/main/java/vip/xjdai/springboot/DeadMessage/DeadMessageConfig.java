package vip.xjdai.springboot.DeadMessage;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeadMessageConfig {



    // 消息交换
    public final static String MESSAGE_EXCHANGE = "message.direct.myexchange";
    // 消息队列名称
    public final static String MESSAGE_QUEUE_NAME = "message.myqueue";
    // 消息路由键
    public final static String MESSAGE_ROUTE_KEY = "message.myroute";

    // 死信消息交换
    public final static String MESSAGE_EXCHANGE_DL = "message.direct.dlexchange";
    // 死信消息队列名称
    public final static String MESSAGE_QUEUE_NAME_DL = "message.dlqueue";
    // 死信消息路由键
    public final static String MESSAGE_ROUTE_KEY_DL = "message.dlroute";

    /**
     * 死信队列交换器
     * @return
     */
    @Bean
    DirectExchange messagedlDirect() {
        return (DirectExchange) ExchangeBuilder.directExchange(MESSAGE_EXCHANGE_DL).durable(true)
                .build();
    }


    /**
     * 死信队列
     * @return
     */
    @Bean
    Queue messagedlQueue() {
        //这里配置的规则就是 当出现死信队列的时候将消息如何处理
        return QueueBuilder.durable(MESSAGE_QUEUE_NAME_DL).withArgument("x-message-ttl", 10000)
                // 配置到期后转发的交换
                .withArgument("x-dead-letter-exchange", MESSAGE_EXCHANGE)
                // 配置到期后转发的路由键
                .withArgument("x-dead-letter-routing-key", MESSAGE_ROUTE_KEY).build();
    }

    /**
     * 将死信队列和转换器绑定
     * @return
     */
    @Bean
    public Binding messageTtlBinding() {
        return BindingBuilder.bind(messagedlQueue()).to(messagedlDirect()).with(MESSAGE_ROUTE_KEY_DL);
    }

    /**
     * 交换配置
     *
     * @return
     */
    @Bean
    public DirectExchange messageDirectExchange() {
        return (DirectExchange) ExchangeBuilder.directExchange(MESSAGE_EXCHANGE)
                .durable(true)
                .build();
    }

    /**
     * 消息队列声明
     *
     * @return
     */
    @Bean
    public Queue messageQueue() {
        return QueueBuilder.durable(MESSAGE_QUEUE_NAME)
                .build();
    }

    /**
     * 消息绑定
     *
     * @return
     */
    @Bean
    public Binding messageBinding() {
        return BindingBuilder.bind(messageQueue())
                .to(messageDirectExchange())
                .with(MESSAGE_ROUTE_KEY);
    }
}
