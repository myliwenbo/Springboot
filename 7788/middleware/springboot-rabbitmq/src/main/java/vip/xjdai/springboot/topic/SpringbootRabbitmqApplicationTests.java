package vip.xjdai.springboot.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {

    @Autowired
    private ApiPaymentSender sender;

    @Test
    public void test_user() {
        sender.user("用户管理！");
        test_userQuery();
    }

    @Test
    public void test_userQuery() {
        sender.userQuery("查询用户信息！");
        test_order();
    }

    @Test
    public void test_order() {
        sender.order("订单管理！");
        test_orderQuery();
    }

    @Test
    public void test_orderQuery() {
        sender.orderQuery("查询订单信息！");
        test_orderDetailQuery();
    }

    @Test
    public void test_orderDetailQuery() {
        sender.orderDetailQuery("查询订单详情信息！");
    }
}
