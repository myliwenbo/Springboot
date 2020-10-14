package vip.xjdai.redis.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class FlowPeakingService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

}
