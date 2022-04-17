package vip.xjdai.enableconfigurationproperties.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import vip.xjdai.enableconfigurationproperties.config.ConfigurationProperties.ConfigurationPropertiesA;
import vip.xjdai.enableconfigurationproperties.config.ConfigurationProperties.ConfigurationPropertiesB;


@Configuration
@EnableConfigurationProperties({
        ConfigurationPropertiesA.class,
        ConfigurationPropertiesB.class
})
public class EnableConfigurationPropertiesConfig {

}
