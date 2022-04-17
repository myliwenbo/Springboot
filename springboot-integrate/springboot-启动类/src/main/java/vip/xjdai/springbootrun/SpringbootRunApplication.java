package vip.xjdai.springbootrun;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


// SpringBootApplication 由三个核心注解组成
// 1. @SpringBootConfiguration-->@Configuration
// 2. @EnableAutoConfiguration--> 初始化导入一些自动装配的类
// 3. @ComponentScan
@SpringBootApplication
public class SpringbootRunApplication {

    public static void main(String[] args) {
        runSpringApplication(args);
        // SpringApplicationRun(args);
    }

    public static void runSpringApplication(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringbootRunApplication.class);
        springApplication.setBannerMode(Banner.Mode.CONSOLE); //新版通过该字符串改版
        // springApplication.setWebApplicationType(WebApplicationType.NONE); // 设置项目类型
        springApplication.run(args);
    }

    /**
     * 推荐使用
     *
     * @param args
     */
    public static void SpringApplicationRun(String[] args) {
        SpringApplication.run(SpringbootRunApplication.class, args);

    }


}
