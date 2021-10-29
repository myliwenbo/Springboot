package vip.xjdai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

class SpringIocApplicationTests {
    private boolean as;

    @Test
    void contextLoads() {
        System.out.println(Import.class.getName());
    }

}
