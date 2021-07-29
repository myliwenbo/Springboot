package vip.xjdai.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;
import org.junit.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import vip.xjdai.filter.ReqResFilter;
import vip.xjdai.servlet.WebSevletOne;

import javax.servlet.ServletConfig;
import java.io.File;

@ComponentScan
public class AnnotatedBeanDefinitionReaderContext {

    public static void main(String[] args) throws LifecycleException {
        File base = new File(System.getProperty("java.io.tmpdir"));
        // 构建tomcat 启动对象
        Tomcat tomcat = new Tomcat();
        setConnector(tomcat);
        Context context = tomcat.addContext("/", base.getAbsolutePath());
        configureFilters(context);
        tomcat.start();
        // 添加 servlet
        addWebServlet(tomcat);
        tomcat.getServer().await();
    }


    public static void setConnector(Tomcat tomcat) {
        //设置Tomcat的端口tomcat.setPort(9091)。两种写法都可以设置端口
        Connector connector = tomcat.getConnector();
        connector.setPort(8080);
        // connector.setProtocol("HTTP/1.1"); // 通过构造函数的方式设置..

    }

    public static void addWebServlet(Tomcat tomcat) {
        WebSevletOne webSevletOne = new WebSevletOne();
        ServletConfig servletConfig = webSevletOne.getServletConfig();
        Wrapper wrapper = tomcat.addServlet("/", "app", new WebSevletOne());
        wrapper.setLoadOnStartup(1);
        wrapper.addMapping("/app");
    }

    private static void configureFilters(Context context) {
        FilterDef filterDef = new FilterDef();//Filter定义
        filterDef.setFilterName("test-filter");
        filterDef.setFilterClass(ReqResFilter.class.getName());
        filterDef.addInitParameter("name", "test-filter");
        context.addFilterDef(filterDef);
        FilterMap filterMap = new FilterMap();//Filter路径映射
        filterMap.setFilterName("test-filter");
        filterMap.addURLPattern("/*");
        context.addFilterMap(filterMap);
    }

}

