package vip.xjdai.redis.order;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FlowPeakingService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 下游服务
     */
    public void test1() {
        try {
            // 假设需要 --> 调用订单服务--> 库存服务-->物流服务..
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 下游服务改用 redis
     */
    public void test2() {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setGoods("手机");
        // 向通道发送了一条消息
        stringRedisTemplate.convertAndSend("channel", JSON.toJSONString(order));
        stringRedisTemplate.convertAndSend("xxxx", JSON.toJSONString(order));
    }
}
