package vip.xjdai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootAnnotationApplication {
    private String name = "你好啊";
    private Integer xxxxxxxxxxxxxxxxxx = 9999;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAnnotationApplication.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行 ShutdownHook ...");
            }
        }));
    }

}
