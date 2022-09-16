package vip.xjdai.springbootconfiguration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vip.xjdai.springbootconfiguration.model.MessageModel;
import vip.xjdai.springbootconfiguration.model.UserModel;

@Configuration
public class ConfigurationConfig {

    @Bean
    public MessageModel getMessageModel() {
        return new MessageModel(getUserModel());
    }

    @Bean
    public UserModel getUserModel() {
        return new UserModel();
    }
}
