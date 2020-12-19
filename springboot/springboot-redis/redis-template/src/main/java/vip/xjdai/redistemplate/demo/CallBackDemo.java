package vip.xjdai.redistemplate.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CallBackDemo {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 可以执行多条命令同时一起执行。。。。
     *
     * @param id
     * @return
     */
    public boolean RedisCallback(String id) {
        // 可以让多条命令同时执行
        stringRedisTemplate.execute(new RedisCallback<Integer>() {
            @Override
            public Integer doInRedis(RedisConnection connection) throws DataAccessException {
                return null;
            }
        });
        return stringRedisTemplate.delete(id);
    }
}
