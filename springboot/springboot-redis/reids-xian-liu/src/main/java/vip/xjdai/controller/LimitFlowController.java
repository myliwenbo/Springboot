package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("LimitFlowController")
public class LimitFlowController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final String IP_PREFIX = "USER_IP";
    private final String BLACK_PREFIX = "LOCKE";


    private final int intervalTime = 1000;

    /**
     * 利用Zset
     * 1. 根据 IP+USER_ID+URL 作为key 去获取
     * 2. 存在利用 rangeByScore 方法  （当前时间- 限制时间）为最小值  当前时间为最大值
     * 3. 判断数据是否大于 限制输
     * 4. 大于则告诉不能请求
     * 5. 不大于则能继续请求
     * > 只要保持在 1000  这个时间段内 没超过5次即可..
     * 其好处是可以做到窗口滑动. 简单说就是  一直访问.. 当大于某个值才不能访问
     *
     * @param request
     * @return
     */
    @RequestMapping("byZSet")
    public String byZSet(HttpServletRequest request) {
        // 获取当前请求时间
        long currentTime = new Date().getTime();
        // 存在
        if (redisTemplate.hasKey("limit")) {
            Integer count = redisTemplate.opsForZSet().rangeByScore("limit", currentTime - intervalTime, currentTime).size();        // intervalTime是限流的时间
            if (count != null && count > 5) {
                return "每分钟最多只能访问5次";
            }
        }
        redisTemplate.opsForZSet().add("limit", UUID.randomUUID().toString(), currentTime);
        return "访问成功";
    }

    /**
     * 思路：
     * 1. 先创建一个黑名单
     * 2. 用户请求的时候 url + user_id + IP 先去获取key
     * 3. 如果key 在黑名单则不让其访问
     * 4. 如果不在黑名单 则根据  url + user_id + IP + back  获取请求次数
     * 5. 如果超过 N 次 则放入到黑名单..
     * 6. 否则放行
     * 利用缓存做到计数器，限制其IP
     *
     * @param request
     * @return
     */
    @RequestMapping("limitFlow")
    public boolean bySetNX(HttpServletRequest request) {
        ValueOperations<String, Object> redisService = redisTemplate.opsForValue();
        String ip = request.getRemoteHost();
        String key = IP_PREFIX + ip;
        //先去获取这个IP 是不是在黑名单中
        Object value = redisService.get(BLACK_PREFIX + ip);
        // 如果在锁中则限制
        if (value != null) {
            // 在黑名单则不让访问
            return false;
        }
        //获取其IP
        Object o = redisService.get(key);
        if (o == null) {
            //进行自增
            redisService.set(key, 1, 2000L, TimeUnit.SECONDS);
        } else if (o.equals(50)) {
            // 2秒超过50个请求就屏蔽掉,放入黑名单,1小时候之后不能访问
            redisService.set(BLACK_PREFIX + ip, 1, 3600L, TimeUnit.SECONDS);
        } else {
            //进行插入
            redisService.increment(key, 1);
        }
        return true;
    }

}
