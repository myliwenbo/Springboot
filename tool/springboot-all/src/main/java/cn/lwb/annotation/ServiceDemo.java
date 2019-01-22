package cn.lwb.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lwb.annotation.dynamic.service.TestService;

@RunWith(SpringRunner.class)
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
