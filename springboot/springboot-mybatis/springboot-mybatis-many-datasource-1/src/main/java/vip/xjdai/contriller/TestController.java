package vip.xjdai.contriller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.aop.TransactionAnnotation;
import vip.xjdai.mapper.one.User;
import vip.xjdai.mapper.one.UserMapper;
import vip.xjdai.mapper.two.Stock;
import vip.xjdai.mapper.two.StockMapper;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.currentTimeMillis;

@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StockMapper stockMapper;

    @RequestMapping("query")
    public void select() {
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123");
        user.setTbPhone("123919239");
        userMapper.insert(user);
        Stock stock = new Stock();
        stock.setName("小明");
        stockMapper.insert(stock);
        user = userMapper.selectByPrimaryKey(user.getUserId());
        stock = stockMapper.selectByPrimaryKey(stock.getId());
        System.out.println(JSON.toJSONString(user));
        System.out.println(JSON.toJSONString(stock));
    }

    @RequestMapping("install")
    @Transactional() //只会对默认事物有效果
    public void install() {
        createAndInstall();
        int i = 1 / 0;
    }

    /**
     * 这样就可以一条也插入不进去了
     */
    @TransactionAnnotation({TransactionAnnotation.TransactionEnum.ONETransaction, TransactionAnnotation.TransactionEnum.TWOTransaction})
    @RequestMapping("install2")
    public void install2() {
        createAndInstall();
        int i = 1 / 0;

    }


    private void createAndInstall() {
        User user = new User();
        user.setUserId((int) currentTimeMillis());
        user.setUserName("张三");
        user.setPassword("123");
        user.setTbPhone("123919239");
        userMapper.insert(user);
        Stock stock = new Stock();
        stock.setName("小明");
        stockMapper.insert(stock);
        System.out.println(JSON.toJSONString(user));
        System.out.println(JSON.toJSONString(stock));
    }

}
