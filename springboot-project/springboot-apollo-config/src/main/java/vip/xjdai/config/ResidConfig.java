/**
 *
 */
package vip.xjdai.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

import lombok.Data;

/**
 * @author lwb
 *
 */
@Configuration
@EnableApolloConfig("application")
@Data
public class ResidConfig {

    @Value("${apollp.redis.ip}")
    private String apollpIp;

    @Value("${apollp.redis.post}")
    private String apollpPort;

}
