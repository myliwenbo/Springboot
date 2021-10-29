package vip.xjdai.springbootcommandlinerunner.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyBean implements CommandLineRunner {



    public void run(String... args) {
        System.out.println("CommandLineRunner函数：" + Arrays.toString(args));
    }
}