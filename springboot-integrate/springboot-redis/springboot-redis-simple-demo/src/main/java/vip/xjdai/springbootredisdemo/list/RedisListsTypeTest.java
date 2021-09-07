package vip.xjdai.springbootredisdemo.list;

import com.google.common.collect.Maps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.UUID;

@SpringBootTest
public class RedisListsTypeTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    ListOperations<String, Object> ops;

    @BeforeEach
    void test() {
        ops = redisTemplate.opsForList();
    }

    @Test
    void putAll() {
        for (int i = 0; i < 10; i++) {
            ops.leftPush("order", i);
        }
    }

    @Test
    void get() {
        System.out.println(ops.leftPop("order"));
    }
}
