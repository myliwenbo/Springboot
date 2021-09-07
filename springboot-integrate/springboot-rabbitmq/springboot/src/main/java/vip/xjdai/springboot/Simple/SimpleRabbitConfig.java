package vip.xjdai.springboot.Simple;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleRabbitConfig {

    public final static String DIRECT_EXCHANGE_NAME = "simple.one";
    public final static String DIRECT_EXCHANGE_NAME_TWO = "simple.two";

    @Bean
    public Queue hello() {
        return new Queue(DIRECT_EXCHANGE_NAME);
    }

    @Bean
    public Queue helloTwo() {
        return new Queue(DIRECT_EXCHANGE_NAME_TWO);
    }
}