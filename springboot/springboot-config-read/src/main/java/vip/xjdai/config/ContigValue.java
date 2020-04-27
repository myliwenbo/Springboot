package vip.xjdai.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 配置文件读取方式，一个一个读取
 *
 * @author lwb
 *
 */
@Data
@Configuration
public class ContigValue
{

    /**
     * 取配置文件值
     */
    @Value("${spring.datasource.primary.driver-class-name}")
    private String driverClassName;
    /**
     * 取配置文件值
     */
    @Value("${spring.datasource.primary.url}")
    private String url;
    /**
     * 取配置文件值
     */
    @Value("${spring.datasource.primary.username}")
    private String username;
    /**
     * 取配置文件值
     */
    @Value("${spring.datasource.primary.password}")
    private String password;

    public ContigValue read()
    {
        return this;
    }

}