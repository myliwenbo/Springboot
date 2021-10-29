package vip.xjdai.springbootenablexx.simple3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

// 假设这个 类 是一个jar 中的类，我们无法修改，但是又想让他被spring所管理如何做呢~那就利用 `@Import`注解好了
public class EanbleImportBean {

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
 