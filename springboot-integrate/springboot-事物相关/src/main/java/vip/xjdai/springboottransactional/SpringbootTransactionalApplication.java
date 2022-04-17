package vip.xjdai.springboottransactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootApplication
public class SpringbootTransactionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTransactionalApplication.class, args);
    }

}
