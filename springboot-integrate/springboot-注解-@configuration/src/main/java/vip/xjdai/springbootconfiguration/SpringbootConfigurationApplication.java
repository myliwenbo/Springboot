package vip.xjdai.springbootconfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import vip.xjdai.springbootconfiguration.config.ComponentConfig;
import vip.xjdai.springbootconfiguration.config.ConfigurationConfig;
import vip.xjdai.springbootconfiguration.model.MessageModel;
import vip.xjdai.springbootconfiguration.model.UserModel;

@ComponentScan
public class SpringbootConfigurationApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SpringbootConfigurationApplication.class);
        applicationContext.refresh();
        UserModel bean = applicationContext.getBean(UserModel.class);
        MessageModel messageModel = applicationContext.getBean(MessageModel.class);
        System.out.println(messageModel.getUserModel());
        System.out.println(bean);
    }

}
