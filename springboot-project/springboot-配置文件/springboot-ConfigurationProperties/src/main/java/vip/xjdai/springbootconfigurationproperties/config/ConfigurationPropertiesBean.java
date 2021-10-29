package vip.xjdai.springbootconfigurationproperties.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 第三种，直接使用这个对象读取即可
 *
 * @author lwb
 */
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "spring.datasource.primary")
public class ConfigurationPropertiesBean {

    private String driverClassName;
    private String type;

    private String url;

    private String username;

    private String password;


}
