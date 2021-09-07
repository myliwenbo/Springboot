package cn.zingfin.finance.repository.dao.impl;

import cn.zingfin.finance.repository.dao.TestCategoryDao;
import cn.zingfin.finance.repository.mapper.TestCategoryMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.zingfin.finance.repository.vo.TestCategoryTdo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author 良田美地天下第一牛逼
 * @since 2020-04-28
 */
@Service
public class TestCategoryDaoImpl extends ServiceImpl<TestCategoryMapper, TestCategoryTdo> implements TestCategoryDao {

}
