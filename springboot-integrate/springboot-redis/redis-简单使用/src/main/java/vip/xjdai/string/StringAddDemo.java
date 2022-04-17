package vip.xjdai.string;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.UUID;

// @SpringBootTest
public class StringAddDemo {


    @Test
    public void add() throws Exception {
        Jedis jedis = new Jedis("192.168.117.128", 6379);
        jedis.set("zhangsan", "小明");
        Set<String> keys = jedis.keys("*");
        keys.forEach(item -> System.out.println(keys));
    }
}
