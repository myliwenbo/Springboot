package vip.xjdai.springbootutils.AOPUtils.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import vip.xjdai.springbootutils.AOPUtils.model.EmployeeServiceImpl;
import vip.xjdai.springbootutils.AOPUtils.model.IEmployeeService;
import vip.xjdai.springbootutils.AOPUtils.model.MyService;

@Configuration
@ComponentScan("vip.xjdai.springbootutils.AOPUtils")
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public IEmployeeService target() {
        return new EmployeeServiceImpl();
    }

    @Bean
    public MyService myComponent() {
        return new MyService();
    }

}