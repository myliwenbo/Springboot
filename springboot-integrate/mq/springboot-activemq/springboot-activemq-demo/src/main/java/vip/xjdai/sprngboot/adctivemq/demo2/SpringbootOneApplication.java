package vip.xjdai.sprngboot.adctivemq.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

import java.util.Collections;
import java.util.Set;


@EnableJms
@SpringBootApplication
public class SpringbootOneApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringbootOneApplication.class);
        springApplication.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        springApplication.run(args);
    }

}
