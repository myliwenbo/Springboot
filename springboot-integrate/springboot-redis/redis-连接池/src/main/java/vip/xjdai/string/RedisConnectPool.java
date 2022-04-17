package vip.xjdai.string;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnectPool {

    // private static final JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMaxTotal(9);
        jedisPoolConfig.setMaxWaitMillis(1000);
        // jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1","3369");

    }
}
