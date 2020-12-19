package vip.xjdai.clienttwo;

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
public class RedisSubscriberTwo extends MessageListenerAdapter {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("仓储服务" + message.toString());
        // 调用 订单服务
    }

}