package vip.xjdai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vip.xjdai.ForDependence.A;

@SpringBootTest
class SpringbooIocApplicationTests {

    @Test
    void contextLoads() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");

    }

}
