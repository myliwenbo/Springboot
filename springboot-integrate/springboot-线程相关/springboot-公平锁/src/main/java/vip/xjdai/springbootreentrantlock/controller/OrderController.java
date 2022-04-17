package vip.xjdai.springbootreentrantlock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springbootreentrantlock.service.OrderService;

import java.util.concurrent.CountDownLatch;

@RestController
@RequestMapping("OrderController")
public class OrderController {
    @Autowired
    private OrderService orderMapper;

    @RequestMapping("test")
    public void test() {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    orderMapper.func();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            countDownLatch.countDown();
        }
    }
}
