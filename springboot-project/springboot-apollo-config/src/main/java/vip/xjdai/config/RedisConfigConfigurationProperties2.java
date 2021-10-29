/**
 *
 */
package vip.xjdai.config;

import java.time.Duration;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Cluster;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Sentinel;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ConfigurationProperties(prefix = "springa.redis")
public class RedisConfigConfigurationProperties2 {

    private int database;

    private String url;

    private String host;

    private String password;

    private String port;

    private boolean ssl;

    private Duration timeout;

    private Sentinel sentinel;

    private Cluster cluster;
}