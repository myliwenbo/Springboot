package vip.xjdai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import vip.xjdai.springboot.direct.PaymentNotifySender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {

    @Autowired
    private PaymentNotifySender sender;

    @Test
    public void test_sender() {
        for (int i = 0; i < 100; i++) {
            sender.sender("支付订单号：" + System.currentTimeMillis());

        }
    }

}
