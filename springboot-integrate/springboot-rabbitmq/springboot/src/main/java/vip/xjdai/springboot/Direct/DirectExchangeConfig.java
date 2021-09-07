package vip.xjdai.springboot.Direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 按照routingkey分发到指定队列
 */
@Configuration
public class DirectExchangeConfig {

    public static String DIRECT_EXCHANGE_NAME = "direct";

    // 消息队列名称
    public final static String MESSAGE_QUEUE_NAME_ONE = "message.myqueue.1";
    public final static String MESSAGE_QUEUE_NAME_TWO = "message.myqueue.2";
    public final static String ORANGE = "orange";
    public final static String BLACK = "black";
    public final static String GREEN = "green";

    @Bean
    public DirectExchange directExchange() {
        /**
         * Queue 可以有4个参数
         *      1.队列名
         *      2.durable       持久化消息队列 ,rabbitmq重启的时候不需要创建新的队列 默认true
         *      3.auto-delete   表示消息队列没有在使用时将被自动删除 默认是false
         *      4.exclusive     表示该消息队列是否只在当前connection生效,默认是false
         */
        return new DirectExchange(DirectExchangeConfig.DIRECT_EXCHANGE_NAME, true,false);
    }

    @Bean
    public Queue directQueue1() {
        // 开启持久化 也就是说 Queue 持久化
        Queue queue = new Queue(DirectExchangeConfig.MESSAGE_QUEUE_NAME_ONE, true);
        return new Queue(DirectExchangeConfig.MESSAGE_QUEUE_NAME_ONE);
    }
    //3个binding将交换机和相应队列连起来
    @Bean
    public Binding bindingorange() {
        Binding binding = BindingBuilder.bind(directQueue1()).to(directExchange()).with(ORANGE);
        return binding;
    }

    @Bean
    public Binding bindingblack() {
        Binding binding = BindingBuilder.bind(directQueue1()).to(directExchange()).with(BLACK);
        return binding;
    }

    @Bean
    public Binding bindinggreen() {
        Binding binding = BindingBuilder.bind(directQueue1()).to(directExchange()).with(GREEN);
        return binding;
    }


}

//Exchange和两个队列绑定在一起

//多个queue绑定同一个key