package vip.xjdai.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class SpringbootRedisApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringbootRedisApplication.class, args);
        // InputStream inputStream = new ByteArrayInputStream("你好啊".getBytes());

    }

}
