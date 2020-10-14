package vip.xjdai.redis.zset.add;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@RequestMapping("zset")
@Component
public class ZSetDemo {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping("add")
    public String add() {
        for (int i = 0; i < 500; i++) {
            Calendar instance = Calendar.getInstance();
            instance.add(Calendar.SECOND, 59 + i);
            long hos = instance.getTimeInMillis();
            stringRedisTemplate.opsForZSet().add("orderId", StringUtils.join("000000000", i + 1), hos);
        }
        return "ok";
    }
}
