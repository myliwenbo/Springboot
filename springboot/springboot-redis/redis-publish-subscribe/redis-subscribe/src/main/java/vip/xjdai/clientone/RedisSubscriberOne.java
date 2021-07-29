package vip.xjdai.clientone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 订单服务
 */
@Component
public class RedisSubscriberOne extends MessageListenerAdapter {


    /**
     * 监听器
     *
     * @param message
     * @param bytes
     */
    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("订单服务" + message.toString());
        // 调用 仓储服务
    }

}