package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("string")
@RestController
public class StringDemo {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("add")
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
