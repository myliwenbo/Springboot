/**
 *
 */
package vip.xjdai.config.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @author lwb
 *
 */
public class DynamicRedisConfig {

    @Bean
    @Primary
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(null);
        config.setPort(1);
        config.setPassword(RedisPassword.of(""));
        config.setDatabase(0);
        return null;
    }
}
