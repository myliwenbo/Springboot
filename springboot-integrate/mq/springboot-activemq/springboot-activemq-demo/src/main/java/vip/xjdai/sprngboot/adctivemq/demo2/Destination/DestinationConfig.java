package vip.xjdai.sprngboot.adctivemq.demo2.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Component
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
