package cn.lwb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 第三种，直接使用这个对象读取即可
 * 
 * @author lwb
 *
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.minor")
public class ConfigThree {

    private String driverClassName;

    private String url;

    private String username;

    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AttributeReadModel [driverClassName=" + driverClassName + ", url=" + url + ", username=" + username
            + ", password=" + password + "]";
    }

}
