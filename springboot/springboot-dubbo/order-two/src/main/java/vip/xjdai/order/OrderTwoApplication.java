package vip.xjdai.order;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @DubboComponentScan(basePackages = "com.chy.user-service.service")  //只扫描指定的包
@EnableDubbo  //会扫描所有的包，从中找出dubbo的@Service标注的类
@SpringBootApplication
public class OrderTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderTwoApplication.class, args);
    }

}
