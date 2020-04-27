package vip.xjdai.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 第三种，直接使用这个对象读取即可
 * 
 * @author lwb
 *
 */
@Data
@ToString
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.minor")
public class ConfigurationPropertiesBean {

    private String driverClassName;

    private String url;

    private String username;

    private String password;



}
