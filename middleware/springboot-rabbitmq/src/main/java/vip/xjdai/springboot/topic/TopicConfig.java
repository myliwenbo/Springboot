package vip.xjdai.springboot.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建消费者
 * @author lwb
 *
 */
@Configuration
public class TopicConfig {
    /**
     * 队列
     * @return
     */
    @Bean
    public Queue coreQueue() {
        return new Queue("api.core");
    }

    /**
     * 队列
     * @return
     */
    @Bean
    public Queue paymentQueue() {
        return new Queue("api.payment");
    }

    /**
     * 转换器
     * @return
     */
    @Bean
    public TopicExchange coreExchange() {
        return new TopicExchange("coreExchange");
    }

    /**
     * 转换器
     * @return
     */
    @Bean
    public TopicExchange paymentExchange() {
        return new TopicExchange("paymentExchange");
    }

    /**
     * 转换器和队列绑定，* 号只能向后多匹配一层路径。
     * @param coreQueue
     * @param coreExchange
     * @return
     */
    @Bean
    public Binding bindingCoreExchange(Queue coreQueue, TopicExchange coreExchange) {
        return BindingBuilder.bind(coreQueue).to(coreExchange).with("api.core.*");
    }

    /**
     * 转换器和队列绑定，# 号可以向后匹配多层路径
     * @param paymentQueue
     * @param paymentExchange
     * @return
     */
    @Bean
    public Binding bindingPaymentExchange(Queue paymentQueue,
                                          TopicExchange paymentExchange) {
        return BindingBuilder.bind(paymentQueue).to(paymentExchange)
            .with("api.payment.#");
    }
}