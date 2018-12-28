package vip.xjdai.mapper2;

import org.springframework.stereotype.Service;
import vip.xjdai.model.Stock;

@Service
public interface TwoStockMapper {
    int deleteByPrimaryKey (Integer id);

    int insert (Stock record);

    int insertSelective (Stock record);

    Stock selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Stock record);

    int updateByPrimaryKey (Stock record);
}
