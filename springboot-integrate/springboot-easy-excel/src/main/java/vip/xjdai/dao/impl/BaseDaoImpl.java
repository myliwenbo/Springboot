package vip.xjdai.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;

import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;
import vip.xjdai.dao.IBaseDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class BaseDaoImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IBaseDao<T> {


    @Override
    public List<T> listBatchByEntityList(List<T> entityList) {
        try (final SqlSession batchSqlSession = sqlSessionBatch()) {
            final int size = entityList.size();
            final int batchSize = 30;
            final List<T> result = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                final String sqlStatement = sqlStatement(SqlMethod.SELECT_LIST);
                final Map<String, Object> param = new MapperMethod.ParamMap<Object>();
                QueryWrapper<T> ew = new QueryWrapper<>(entityList.get(i));
                param.put("ew", ew);
                param.put("param1", ew);
                final List<T> list = batchSqlSession.selectList(sqlStatement, param);
                result.addAll(list);
                if (i >= 1 && i % batchSize == 0) {
                    batchSqlSession.flushStatements();
                }
            }
            batchSqlSession.flushStatements();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
