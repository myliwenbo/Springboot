package vip.xjdai.redis.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.redis.pojo.User;

import java.time.Duration;

/**
 * Zstnx 的一个简单演示
 */
@RestController
@RequestMapping("LimitFlowController")
public class SetnxController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("lock")
    public void lock() {
        String usetId = "dac73921dc3a4ed18ce2b57161a4894c";
        ValueOperations<String, String> vo = stringRedisTemplate.opsForValue();
        //setnx
        //加上一个锁
        Boolean aBoolean = vo.setIfAbsent("lock-dac73921dc3a4ed18ce2b57161a4894c", "dac73921dc3a4ed18ce2b57161a4894c",
                Duration.ofDays(1));
        //代表了 true
        if (aBoolean) {
            User value = new User();
            value.setAge("19");
            value.setId("dac73921dc3a4ed18ce2b57161a4894c");
            value.setName("测试");
            vo.set("user-token-dac73921dc3a4ed18ce2b57161a4894c", JSON.toJSONString(value));
        } else {
            //获取其过期时间，秒
            Long expire = stringRedisTemplate.getExpire("lock-dac73921dc3a4ed18ce2b57161a4894c");
            System.out.println(expire);
        }
        //解锁
        //        redisTemplate.delete("lock-dac73921dc3a4ed18ce2b57161a4894c");
    }
}
