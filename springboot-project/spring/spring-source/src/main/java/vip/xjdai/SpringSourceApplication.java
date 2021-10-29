package vip.xjdai;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.xjdai.config.Appconfig;//@SpringBootApplication
//public class SpringSourceApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(SpringSourceApplication.class, args);
//    }
//
//}

public class SpringSourceApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Appconfig.class);
        Runtime runtime = Runtime.getRuntime();

    }

}
