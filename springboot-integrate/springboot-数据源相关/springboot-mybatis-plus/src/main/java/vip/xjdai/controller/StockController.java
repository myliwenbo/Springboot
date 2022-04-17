package vip.xjdai.controller;
import java.util.Date;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.mapper.StockMapper;
import vip.xjdai.model.Stock;

@RequestMapping
@RestController
public class StockController {

    @Autowired
    private StockMapper stockMapper;

    @RequestMapping("test")
    public void install() {
        for (int i = 10000; i < 100000; i++) {
            Stock user = new Stock();
            user.setId(i);
            user.setName(i + "");
            user.setIntValue(i + "");
            stockMapper.insert(user);

        }

    }

    @RequestMapping("query")
    public void query() {
        QueryWrapper<Stock> stockQueryWrapper = new QueryWrapper<>();
        stockQueryWrapper.eq("", "");
        stockMapper.selectList(stockQueryWrapper);
    }

    @RequestMapping("setEntity")
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


}
