package vip.xjdai.springbootinitializr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
@EnableCaching
@SpringBootApplication
public class SpringbootInitializrApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootInitializrApplication.class, args);
    }


}
