/**
 *
 */
package vip.xjdai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vip.xjdai.config.RedisConfigConfigurationProperties;
import vip.xjdai.config.RedisConfigConfigurationProperties2;
import vip.xjdai.config.ResidConfig;

/**
 * @author lwb
 *
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private ResidConfig residConfig;

    @Autowired
    private RedisConfigConfigurationProperties redisConfigConfigurationProperties;

    @Autowired
    private RedisConfigConfigurationProperties2 redisConfigConfigurationProperties2;

    @Value("${redis.password}")
    private String apollpIp;

    @Value("${springa.redis.password}")
    private String apollpSpringPassword;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("test")
    public String test() {
        System.out.println(redisConfigConfigurationProperties.getHost());
        System.out.println(redisConfigConfigurationProperties2.toString());
        System.out.println(redisConfigConfigurationProperties2.getPassword());
        System.out.println(apollpSpringPassword);
        System.out.println(apollpIp);
        System.out.println(stringRedisTemplate.keys("*").toString());
        StringBuffer sb = new StringBuffer();
        sb.append(residConfig.getApollpIp()).append("---------------------");
        sb.append(residConfig.getApollpPort());
        return sb.toString();
    }
}
