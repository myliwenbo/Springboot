package vip.xjdai.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.config.Order;

import java.util.UUID;

@RestController
@RequestMapping("traffic")
public class FlowPeakingController {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 这是一个秒杀服务，由于是同步的，假设我们调用这个服务，只能等待整个服务调用完整..
     * 那要如何处理呢？利用redis中的消息队列来完成
     */
    @RequestMapping("spike1")
    public void spike1() {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setGoods("手机");
        // 向通道发送了一条消息
        stringRedisTemplate.convertAndSend("channel", JSON.toJSONString(order));
        stringRedisTemplate.convertAndSend("xxxx", JSON.toJSONString(order));
    }

}
