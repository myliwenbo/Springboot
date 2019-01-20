package vip.xjdai.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import vip.xjdai.SpringbootMybatisDataSourceApplication;
import vip.xjdai.mapper1.OneStockMapper;
import vip.xjdai.mapper2.TwoStockMapper;
import vip.xjdai.model.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisDataSourceApplication.class)
public class Demo {

    @Autowired()
    OneStockMapper oneStockMapper;

    @Autowired()
    TwoStockMapper twoStockMapper;

    @Test
    public void index() {
        Stock test = new Stock();
        test.setId(6);
        test.setName("888");
        oneStockMapper.insert(test);
        twoStockMapper.insert(test);
        Stock entity = oneStockMapper.selectByPrimaryKey(5);
        Stock twoEntity = twoStockMapper.selectByPrimaryKey(5);
        System.out.println(entity.toString());
        System.out.println(twoEntity.toString());
    }

}
