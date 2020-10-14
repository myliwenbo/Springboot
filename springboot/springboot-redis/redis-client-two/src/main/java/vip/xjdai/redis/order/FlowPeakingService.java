package vip.xjdai.redis.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FlowPeakingService {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static void main( String[] args) {

    }

}
