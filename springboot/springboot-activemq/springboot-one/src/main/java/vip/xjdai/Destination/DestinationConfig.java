package vip.xjdai.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class DestinationConfig {

    //定义存放消息的队列
    @Bean("queue")
    public Queue queue() {
        return new ActiveMQQueue("queue");
    }

    //定义存放消息的队列
    @Bean("topic")
    public Topic topic() {
        return new ActiveMQTopic("video.topic");
    }
}
