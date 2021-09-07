package vip.xjdai.simplethreadlocaldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleThreadLocalDemoApplication {

    public static void main(String[] args) {
        ThreadLocal<String> value = new ThreadLocal();
        value.set("123");
        SpringApplication.run(SimpleThreadLocalDemoApplication.class, args);
    }

}
