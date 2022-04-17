package vip.xjdai.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.xjdai.mapper.StockMapper;
import vip.xjdai.model.Stock;

import java.util.List;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests {

    @Autowired
    private StockMapper stockMapper;

    @Test
    public void insert() {
        for (int i = 0; i < 10; i++) {
            Stock user = new Stock();
            user.setId(i);
            user.setName(i + "");
            user.setIntValue(i + "");
            stockMapper.insert(user);
        }
    }

    @Test
    public void update() {
        for (int i = 0; i < 10; i++) {
            Stock user = new Stock();
            user.setId(i);
            user.setName(i + "");
            user.setIntValue(i + "");
            stockMapper.updateById(user);
        }
    }

    @Test
    public void setEntity() {
        Stock stock = new Stock();
        stock.setName("");
        stock.setIntValue("");
        stock.setRevision(0);
        stock.setCreatedBy("");
        stock.setIsDel("");
        stock.setUpdatedBy("");
        QueryWrapper<Stock> stockQueryWrapper = new QueryWrapper<>();
        stockQueryWrapper.setEntity(new Stock());
        stockMapper.selectList(stockQueryWrapper);
    }


    @Test
    public void delete() {
        QueryWrapper<Stock> stockQueryWrapper = new QueryWrapper<>();
        stockMapper.delete(stockQueryWrapper);
    }

    @Test
    public void query() {
        QueryWrapper<Stock> stockQueryWrapper = new QueryWrapper<>();
        List<Stock> stocks = stockMapper.selectList(null);
        stocks.forEach(System.out::println);
    }

}
