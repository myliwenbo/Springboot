package vip.xjdai.mapper1;

import org.springframework.stereotype.Service;
import vip.xjdai.model.Stock;

@Service
public interface OneStockMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
}
