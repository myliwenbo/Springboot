package vip.xjdai.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

public class BaseDaoImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IBaseDao<T> {
    /**
     * 批量插入
     *
     * @param entityList ignore
     * @param batchSize  ignore
     * @return ignore
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveBatch(Collection<T> entityList, int batchSize) {

        String sqlStatement = SqlHelper.table(currentModelClass()).getSqlStatement(CustSqlMethod.INSERT_BATCH.getMethod());
        try (SqlSession batchSqlSession = sqlSessionBatch()) {
            int i = 0;
            ArrayList<T> partitionList = new ArrayList<>(batchSize);
            for (T anEntityList : entityList) {
                partitionList.add(anEntityList);
                if (i >= 1 && i % batchSize == 0) {
                    flush(sqlStatement, batchSqlSession, partitionList);
                }
                i++;
            }
            flush(sqlStatement, batchSqlSession, partitionList);
        }
        return true;
    }

    private void flush(String sqlStatement, SqlSession batchSqlSession, ArrayList<T> partitionList) {
        batchSqlSession.insert(sqlStatement, partitionList);
        batchSqlSession.commit();
        batchSqlSession.flushStatements();
    }
}
