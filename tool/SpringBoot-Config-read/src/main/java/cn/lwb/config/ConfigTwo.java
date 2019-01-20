package cn.lwb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.lwb.model.AttributeReadModel;

/**
 * 配置文件读取方式，自动映射进去<br/>
 * 常用与不能修改的对象，例如：datasource
 * 
 * @author lwb
 *
 */
@Configuration
public class ConfigTwo {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.minor")
    public AttributeReadModel druidDataSource() {
        return new AttributeReadModel();
    }

}
