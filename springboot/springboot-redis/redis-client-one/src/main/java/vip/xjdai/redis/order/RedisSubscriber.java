package vip.xjdai.redis.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

/**
 * 监听器
 */
@Component
public class RedisSubscriber extends MessageListenerAdapter {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("订单服务" + message.toString());
        // 调用 订单服务
    }

    //发布订阅模式
    public ChannelTopic channelTopic() {
        return new ChannelTopic("channel");
    }


    public PatternTopic patternTopic() {
        return new PatternTopic("pattern");
    }


    /**
     * 容器配置
     *
     * @param connectionFactory
     * @param listenerAdapter   配置的监听器
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, channelTopic());
        container.addMessageListener(listenerAdapter, patternTopic());//配置要订阅的订阅项
        return container;
    }
}