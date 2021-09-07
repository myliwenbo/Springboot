package vip.xjdai.sprinbtooredisson.controller;

import org.redisson.RedissonLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("redisson")
public class RedissonController {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static final String product = "MoonCake";

    private final Object object = new Object();

    @RequestMapping("lockAdd")
    public void lockAdd() throws Exception {

        //对数据进行加锁
        RedissonLock lock = (RedissonLock) redissonClient.getLock(product);
        //加锁
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        String stocks = stringRedisTemplate.opsForValue().get("stock");
        int stock = Integer.parseInt(stocks);
        if (stock > 0) {
            //下单
            stock -= 1;
            stringRedisTemplate.opsForValue().set("stock", String.valueOf(stock));
            System.out.println("扣减成功，库存stock：" + stock);
            Thread.sleep(5000000);
        } else {
            //没库存
            System.out.println("扣减失败，库存不足");
        }
        //解锁
        lock.unlock();

    }

    @RequestMapping("synchronizedAdd")
    public void synchronizedAdd() throws Exception {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName());
            String stocks = stringRedisTemplate.opsForValue().get("stock");
            int stock = Integer.parseInt(stocks);
            if (stock > 0) {
                //下单
                stock -= 1;
                stringRedisTemplate.opsForValue().set("stock", String.valueOf(stock));
                System.out.println("扣减成功，库存stock：" + stock);
                Thread.sleep(5000);
            } else {
                //没库存
                System.out.println("扣减失败，库存不足");
            }
        }
    }


    @RequestMapping("addStock")
    public void addStock() throws Exception {
        ListOperations<String, String> stringStringListOperations = stringRedisTemplate.opsForList();

    }

}
