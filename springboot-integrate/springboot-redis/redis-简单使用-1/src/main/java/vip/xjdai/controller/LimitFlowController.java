package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("LimitFlowController")
public class LimitFlowController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final String IP_PREFIX = "USER_IP";
    private final String BLACK_PREFIX = "LOCKE";

    /**
     * 利用缓存做到计数器，限制其IP
     *
     * @param request
     * @return
     */
    @RequestMapping("limitFlow")
    public boolean limitFlow(HttpServletRequest request) {
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
