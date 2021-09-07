package vip.xjdai.springbootcontrolleradvice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.time.LocalDateTime;

@SpringBootApplication (exclude = {
        HibernateJpaAutoConfiguration.class, //拒绝启动的时候查找JPA配置
        DataSourceAutoConfiguration.class})// 拒绝启动的时候连接数据库
public class SpringbootControllerAdviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootControllerAdviceApplication.class, args);
    }







}
