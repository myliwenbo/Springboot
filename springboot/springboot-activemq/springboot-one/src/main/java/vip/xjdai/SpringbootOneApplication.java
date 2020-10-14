package vip.xjdai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;


@EnableJms
@SpringBootApplication
public class SpringbootOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootOneApplication.class, args);
    }

}
