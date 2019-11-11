package vip.xjdai.Contriller;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.mapper1.OneStockMapper;
import vip.xjdai.mapper2.TwoStockMapper;
import vip.xjdai.model.Stock;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("test")
@RestController
public class TestController {

    @Autowired()
    OneStockMapper oneStockMapper;

    @Autowired()
    TwoStockMapper twoStockMapper;

    @RequestMapping("test")
    public List<Stock> test() {
        Stock test = new Stock();
        test.setId(10);
        test.setName("小明");
        oneStockMapper.insert(test);
        twoStockMapper.insert(test);
        Stock entity = oneStockMapper.selectByPrimaryKey(5);
        Stock twoEntity = twoStockMapper.selectByPrimaryKey(5);
        ArrayList<Stock> objects = Lists.newArrayList();
        objects.add(entity);
        objects.add(twoEntity);
        return objects;

    }

}
