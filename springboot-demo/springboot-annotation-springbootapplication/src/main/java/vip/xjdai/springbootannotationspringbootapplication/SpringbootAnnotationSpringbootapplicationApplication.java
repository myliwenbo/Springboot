package vip.xjdai.springbootannotationspringbootapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootAnnotationSpringbootapplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAnnotationSpringbootapplicationApplication.class, args);
    }

}


// SpringBootApplication 由三个核心注解组成
// 1. @SpringBootConfiguration-->@Configuration
// 2. @EnableAutoConfiguration
// 3. @ComponentScan