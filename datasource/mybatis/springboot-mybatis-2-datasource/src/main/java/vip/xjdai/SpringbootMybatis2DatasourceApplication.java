package vip.xjdai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = { //拒绝启动的时候查找JPA配置
        DataSourceAutoConfiguration.class }) // 拒绝启动的时候连接数据库
@ServletComponentScan
//配置druid必须加的注解，如果不加，访问页面打不开，filter和servlet、listener之类的需要单独进行注册才能使用，spring boot里面提供了该注解起到注册作用
public class SpringbootMybatis2DatasourceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootMybatis2DatasourceApplication.class, args);
    }

}
