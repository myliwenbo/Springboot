package vip.xjdai.zsetnx;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.pojo.User;

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
    public String lock() {
        ValueOperations<String, String> vo = stringRedisTemplate.opsForValue();
        //setnx
        //加上一个锁
        Boolean aBoolean = vo.setIfAbsent("lock-xxxx", "dac73921dc3a4ed18ce2b57161a4894c",Duration.ofDays(1));
        //代表了 true
        if (aBoolean) {
            User value = new User();
            value.setAge("19");
            value.setId("dac73921dc3a4ed18ce2b57161a4894c");
            value.setName("测试");
            vo.set("user-token-dac73921dc3a4ed18ce2b57161a4894c", JSON.toJSONString(value));
            return "加锁成功";
        } else {
            //获取其过期时间，秒
            Long expire = stringRedisTemplate.getExpire("lock-dac73921dc3a4ed18ce2b57161a4894c");
            System.out.println(expire);
            // 这里可以返回信息，或者进行递归操作...
            return "尚未解锁";
        }
    }
}
