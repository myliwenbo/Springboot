package vip.xjdai.enableconfigurationproperties;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import vip.xjdai.enableconfigurationproperties.config.ConfigurationProperties.ConfigurationPropertiesA;

@SpringBootApplication
public class EnableConfigurationPropertiesApplication implements SmartInitializingSingleton {

    @Autowired
    private ConfigurationPropertiesA configurationPropertiesA;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(EnableConfigurationPropertiesApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        System.out.println(environment.getProperty("a.url"));

    }

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println(configurationPropertiesA.getUrl());
    }
}
