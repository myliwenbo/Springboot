package vip.xjdai.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 配置druid需要的配置类，引入application.yml文件中以 <br/>
 * spring.datasource开头的信息 因此需要在application.yml文件中配置相关信息。
 *
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        System.out.println("搭建data");
        return druidDataSource;
    }
}