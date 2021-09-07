package vip.xjdai.springbootredisdemo.hash;

import com.google.common.collect.Maps;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;

@SpringBootTest
public class RedisHashTypeTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    HashOperations<String, Object, Object> ops;

    @BeforeEach
    void test() {
        ops = redisTemplate.opsForHash();
    }

    @Test
    void putAll() {
        HashMap<String, String> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put("userName", "张三");
        objectObjectHashMap.put("password", "123");
        ops.putAll("user", objectObjectHashMap);
    }

    @Test
    void get() {
        Object o = ops.get("user", "userName");
        System.out.println(o);
    }
}
