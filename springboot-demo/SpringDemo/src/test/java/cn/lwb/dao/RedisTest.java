package cn.lwb.dao;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lwb.dao.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        String string = stringRedisTemplate.opsForValue().get("aaa");
        System.out.println(string);
    }

    @Test
    public void testObj() throws Exception {
        User user = new User("aa@126.com", "aa", "aa123456", "aa", "123");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.neox", user);
        operations.set("com.neo.f", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        boolean exists = redisTemplate.hasKey("com.neo.f");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
    }

    @Test
    public void get() throws InterruptedException {
        Object object = redisTemplate.opsForValue().get("com.neox");//操作字符串
        Thread.sleep(1000);
        User user = (User) object;
        System.out.println(user.toString() + "1111111");
        redisTemplate.opsForHash();//操作hash
        redisTemplate.opsForList();//操作list
        redisTemplate.opsForSet();//操作set
        redisTemplate.opsForZSet();//操作有序set
    }
}
