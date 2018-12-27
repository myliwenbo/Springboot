package cn.lwb.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lwb.SpringBootMybatisDataSourceApplication;
import cn.lwb.mapper1.OneStockMapper;
import cn.lwb.mapper2.TwoStockMapper;
import cn.lwb.model.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMybatisDataSourceApplication.class)
public class Demo {

    @Autowired()
    OneStockMapper oneStockMapper;

    @Autowired()
    TwoStockMapper twoStockMapper;

    @Test
    public void index() {
        Stock test = new Stock();
        test.setId(11);
        test.setName("小明");
        oneStockMapper.insertSelective(test);
        twoStockMapper.insertSelective(test);
        Stock entity = oneStockMapper.selectByPrimaryKey(1);
        Stock twoEntity = twoStockMapper.selectByPrimaryKey(1);
        System.out.println(entity.toString());
        System.out.println(twoEntity.toString());
    }

}
