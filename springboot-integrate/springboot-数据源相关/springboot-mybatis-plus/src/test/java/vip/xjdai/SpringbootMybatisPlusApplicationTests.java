package vip.xjdai;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

}
