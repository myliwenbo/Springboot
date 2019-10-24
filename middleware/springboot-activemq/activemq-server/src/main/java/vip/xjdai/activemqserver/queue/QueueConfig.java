package vip.xjdai.activemqserver.queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Destination;
import javax.jms.Queue;

@Configuration
public class QueueConfig
{
    /**
     *  点对点
     * @return
     */
    @Bean(name="queue1")
    public Destination queue1()
    {
        return new ActiveMQQueue("queue1");
    }  //定义存放消息的队列

    /**
     * 点对点
     * @return
     */
    @Bean
    public Destination queue2()
    {
        return new ActiveMQQueue("ActiveMQQueue");
    }
    /**
     * 发布/订阅
     * @return
     */
    @Bean
    public Destination topic1()
    {
        return new ActiveMQTopic("ActiveMQQueue");
    }

    /**
     * 发布/订阅
     * @return
     */
    @Bean(name="topic2")
    public Destination topic2()
    {
        return new ActiveMQTopic("topic2");
    }

}
