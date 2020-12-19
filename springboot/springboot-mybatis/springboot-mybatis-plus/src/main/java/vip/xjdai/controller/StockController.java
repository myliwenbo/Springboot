package vip.xjdai.controller;

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
            user.setIntValue(i);
            stockMapper.insert(user);
        }

    }

}
