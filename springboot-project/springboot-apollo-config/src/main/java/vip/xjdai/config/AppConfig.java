/**
 *
 */
package vip.xjdai.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

/**
 * @author lwb
 *
 */
@Configuration
@EnableApolloConfig({"test", "TEST1.redis"})
public class AppConfig {

    @Autowired
    private org.springframework.cloud.context.scope.refresh.RefreshScope refreshScope;

    /**
     * 配置监听器
     * @param changeEvent
     */
    @ApolloConfigChangeListener({"test", "TEST1.redis"})
    public void onChange(ConfigChangeEvent changeEvent) {
        refreshScope.refresh("redisConfigConfigurationProperties2");
        refreshScope.refresh("redisConfigConfigurationProperties");
    }

    @Bean("redisConfigConfigurationProperties2")
    @RefreshScope
    public RedisConfigConfigurationProperties2 javaConfigBean2() {
        return new RedisConfigConfigurationProperties2();
    }

    @Bean("redisConfigConfigurationProperties")
    @RefreshScope
    @Primary
    public RedisConfigConfigurationProperties javaConfigBean3() {
        return new RedisConfigConfigurationProperties();
    }
}
