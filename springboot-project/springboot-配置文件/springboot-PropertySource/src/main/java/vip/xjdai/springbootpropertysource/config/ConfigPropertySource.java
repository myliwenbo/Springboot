package vip.xjdai.springbootpropertysource.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
// 指定读取配置文件，这里读取properties
@PropertySource("classpath:application-pay.properties")
// ignoreUnknownFields = false 忽略未知的字段
// ignoreInvalidFields         是否忽略验证失败的字段
@ConfigurationProperties(prefix = "com.dudu", ignoreUnknownFields = false) // 然后自动映射
public class ConfigPropertySource {
    private String name;
    private String want;
    private String jh;
    private String wantJh;

}
