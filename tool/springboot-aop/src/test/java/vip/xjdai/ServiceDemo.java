package vip.xjdai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.xjdai.ioc.service.TestService;

@SpringBootTest
public class ServiceDemo {

    @Autowired
    private TestService testServiceImpl;

    @Autowired
    private TestService testServiceImpl2;

    @Test
    public void test() {
        testServiceImpl.whoAmI();
        testServiceImpl2.whoAmI();
    }
}
