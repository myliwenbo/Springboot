package vip.xjdai.zsetnx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.Collections;
import java.util.UUID;

@RequestMapping("redisLock")
@RestController
public class RedisLock {


    private final String lock_key = "redis_lock"; //锁键

    protected long internalLockLeaseTime = 30000;//锁过期时间

    private final long timeout = 10000; //获取锁的超时时间

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    /**
     * 加锁
     *
     * @param id
     * @return
     */
    public boolean lock(String id) {
        ValueOperations<Object, Object> objectObjectValueOperations = redisTemplate.opsForValue();
        Long start = System.currentTimeMillis();
        for (; ; ) {
            //这里的超时时间为 1天....
            //
            Boolean aBoolean = objectObjectValueOperations.setIfAbsent(lock_key, id, Duration.ofDays(1));
            //SET命令返回OK ，则证明获取锁成功
            if (aBoolean) {
                return aBoolean;
            }
            //否则循环等待，在timeout时间内仍未获取到锁，则获取失败
            long l = System.currentTimeMillis() - start;
            if (l >= timeout) {
                return false;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return false;
            }
        }
    }

    static class Singleton {
        static DefaultRedisScript<Long> integerDefaultRedisScript = new DefaultRedisScript<>();

        static {
            String script =
                    "if redis.call('get',KEYS[1]) == ARGV[1] then" +
                            "   return redis.call('del',KEYS[1]) " +
                            "else" +
                            "   return 0 " +
                            "end";
            // 通过读取资源文件...
            // integerDefaultRedisScript.setScriptSource(new ResourceScriptSource(value));
            integerDefaultRedisScript.setScriptText(script);
            integerDefaultRedisScript.setResultType(Long.class);
        }

        //在调用的时候才去初始化当前类，利用内部类和类加载机制
        public static DefaultRedisScript<Long> getInstance() {
            return integerDefaultRedisScript;
        }
    }

    public boolean unlock(String id) {
        Long execute = redisTemplate.execute(Singleton.getInstance(),
                Collections.singletonList(lock_key), id);
        return execute==1;
    }

    public void service() {
        String id = UUID.randomUUID().toString();

        //加锁成功
        if (lock(id)) {
            //执行业务
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
            // 执行完毕后解锁
            boolean unlock = unlock(id);
            System.out.println(unlock);
        } else {
            System.out.println(Thread.currentThread().getName() + "：获取锁失败");
        }
    }


    @RequestMapping("testLock")
    public void test() {
        for (int i = 0; i < 10; i++) {
            new Thread(this::service).start();
        }
    }
}