package vip.xjdai.springbootconditional.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import vip.xjdai.springbootconditional.conditionalConfig.SysCondition;

@Configuration
public class BeanConfig {

    @Bean("windiws")
    @Conditional(SysCondition.WindowscConditional.class)
    public SysService getwindows() {
        return new WindowsSysService();
    }

    @Bean("linux")
    @Conditional(SysCondition.LinuxConditional.class)
    public SysService getLinux() {
        return new LinuxSysService();
    }
}
