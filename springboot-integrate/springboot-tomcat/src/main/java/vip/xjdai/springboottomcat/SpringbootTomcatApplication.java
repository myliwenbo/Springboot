package vip.xjdai.springboottomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

@ComponentScan
public class SpringbootTomcatApplication {

    public static void main(String[] args) throws LifecycleException {
        File base = new File(System.getProperty("java.io.tmpdir"));

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.addContext("/", base.getAbsolutePath());
        tomcat.start();
        //容器添加需要启动的ApplicationContext
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext
                = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(SpringbootTomcatApplication.class);
        annotationConfigWebApplicationContext.refresh();
        //创建 servlet 并添加到 tomcat 中
        DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigWebApplicationContext);
        Wrapper wrapper = tomcat.addServlet("/", "app", dispatcherServlet);
        wrapper.setLoadOnStartup(1);
        wrapper.addMapping("/");
        tomcat.getServer().await();
    }
}
