package vip.xjdai.springboot.Topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//topic交换机模型，需要一个topic交换机，两个队列和三个binding
@Configuration
public class TopicExchangeConfig {

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("mytopic");
    }

    @Bean
    public Queue topicQueue1() {
        return new Queue("topicqueue1");
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue("topicqueue2");
    }

    //3个binding将交换机和相应队列连起来
    @Bean
    public Binding bindingtopic1() {
        //binding key
        Binding binding = BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("*.orange.*");
        return binding;
    }

    @Bean
    public Binding bindingtopic2() {
        Binding binding = BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("*.*.rabbit");
        return binding;
    }

    @Bean
    public Binding bindingtopic3() {
        //#表示0个或若干个关键字，*表示一个关键字
        Binding binding = BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("lazy.#");
        return binding;
    }
}