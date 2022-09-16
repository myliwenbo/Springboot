package vip.xjdai.springbootcmdvalue.config;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println(JSON.toJSONString(args));
    }
}