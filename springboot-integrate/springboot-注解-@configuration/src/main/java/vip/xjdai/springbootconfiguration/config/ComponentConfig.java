package vip.xjdai.springbootconfiguration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import vip.xjdai.springbootconfiguration.model.MessageModel;
import vip.xjdai.springbootconfiguration.model.UserModel;

// @Component
public class ComponentConfig {

    @Bean
    public MessageModel getMessageModel() {
        return new MessageModel(getUserModel());
    }

    @Bean
    public UserModel getUserModel() {
        return new UserModel();
    }

}
