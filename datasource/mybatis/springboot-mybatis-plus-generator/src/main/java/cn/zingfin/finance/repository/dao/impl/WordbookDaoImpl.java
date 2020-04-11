package cn.zingfin.finance.repository.dao.impl;

import cn.zingfin.finance.repository.entity.Wordbook;
import cn.zingfin.finance.mapper.WordbookMapper;
import cn.zingfin.finance.repository.dao.IWordbookDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author quyl
 * @since 2020-02-12
 */
@Service
public class WordbookDaoImpl extends ServiceImpl<WordbookMapper, Wordbook> implements IWordbookDao {

}
