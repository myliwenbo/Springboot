package vip.xjdai.springbootaware.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationAwareConfig implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationAwareConfig bean = applicationContext.getBean(ApplicationAwareConfig.class);
        System.out.println(bean);
    }
}
