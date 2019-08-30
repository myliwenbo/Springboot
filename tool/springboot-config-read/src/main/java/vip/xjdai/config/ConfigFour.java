package vip.xjdai.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties") // 指定读取配置文件，这里读取properties 是一样的效果
@ConfigurationProperties(prefix = "com.dudu") // 然后自动映射
public class ConfigFour {

    private String name;
    private String want;
    private String jh;
    private String wantJh;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }

    public String getJh() {
        return jh;
    }

    public void setJh(String jh) {
        this.jh = jh;
    }

    public String getWantJh() {
        return wantJh;
    }

    public void setWantJh(String wantJh) {
        this.wantJh = wantJh;
    }

    @Override
    public String toString() {
        return "ConfigFour [name=" + name + ", want=" + want + ", jh=" + jh + ", wantJh=" + wantJh + "]";
    }

}
