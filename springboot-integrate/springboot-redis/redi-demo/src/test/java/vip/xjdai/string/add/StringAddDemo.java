package vip.xjdai.string.add;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringAddDemo {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void add() throws Exception {
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                stringRedisTemplate.opsForValue().set("ORDER" + UUID.randomUUID().toString(), UUID.randomUUID().toString());
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                stringRedisTemplate.opsForValue().set("ORDER" + UUID.randomUUID().toString(), UUID.randomUUID().toString());
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                stringRedisTemplate.opsForValue().set("ORDER-1" + UUID.randomUUID().toString(), UUID.randomUUID().toString());
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                stringRedisTemplate.opsForValue().set("ORDER-1" + UUID.randomUUID().toString(), UUID.randomUUID().toString());
            }
        }).start();
    }
}
