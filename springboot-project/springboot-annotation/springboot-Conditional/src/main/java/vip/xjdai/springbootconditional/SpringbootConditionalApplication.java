package vip.xjdai.springbootconditional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import vip.xjdai.springbootconditional.service.SysService;


@ComponentScan("vip.xjdai")
public class SpringbootConditionalApplication {

    public static void main(String[] args) {
        ApplicationContext ax = new AnnotationConfigApplicationContext(SpringbootConditionalApplication.class);
        SysService bean = ax.getBean(SysService.class);
        bean.sysHandle();
    }

}
