/**
 *
 */
package vip.xjdai.config;

import org.springframework.context.annotation.Configuration;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

@Configuration
@EnableApolloConfig({"TEST1.ttt"}) //配置redis配置到到spring环境中
public class RedisConfigConfigurationProperties3 {
}