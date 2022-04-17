package vip.xjdai.springbootenablexx;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import vip.xjdai.springbootenablexx.ImportSelector.EanbleImportSelector;
import vip.xjdai.springbootenablexx.ImportSelector.UserBean;
import vip.xjdai.springbootenablexx.simple.SimpleImportBeanDemoB;
import vip.xjdai.springbootenablexx.simple2.EanbleImportBeanDemo;
import vip.xjdai.springbootenablexx.simple3.SysService;


@EnableAsync
@EanbleImportSelector(UserBean.class)
@ComponentScan
public class SpringbootEnableXxApplication {

    public static void main(String[] args) {
//        SpringbootEnableXxApplication.simple();
//        SpringbootEnableXxApplication.EnableSimple();
//        SpringbootEnableXxApplication.EnableSimple2();
        SpringbootEnableXxApplication.eanbleImportSelector();
    }

    public static void simple() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringbootEnableXxApplication.class);
        SimpleImportBeanDemoB bean = context.getBean(SimpleImportBeanDemoB.class);
        System.out.println(bean);

    }

    // //@EnableSimple
    public static void EnableSimple() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringbootEnableXxApplication.class);
        EanbleImportBeanDemo bean = context.getBean(EanbleImportBeanDemo.class);
        System.out.println(bean);

    }

    //@EnableSimple2
    public static void EnableSimple2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringbootEnableXxApplication.class);
        SysService bean = context.getBean(SysService.class);
        bean.sysHandle();

    }

    //@EanbleImportSelector(UserBean.class)
    public static void eanbleImportSelector() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringbootEnableXxApplication.class);
        UserBean bean = context.getBean(UserBean.class);

        System.out.println(bean);
    }

}
