package vip.xjdai.springbootreentrantlock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.xjdai.springbootreentrantlock.service.OrderService;

import java.util.concurrent.CountDownLatch;

@SpringBootTest
class SpringbootReentrantLockApplicationTests {

    @Autowired
    private OrderService orderMapper;


    @Test
    void contextLoads() {
        CountDownLatch value = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    value.await();
                    orderMapper.func();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            value.countDown();
        }
    }
}
