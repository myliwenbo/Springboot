package vip.xjdai.config;

import cn.hutool.core.collection.CollectionUtil;
import lombok.Data;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

import java.util.Map;

@Data
/**
 * 动态切换数据源
 *
 * @author lwb
 */

public class MyRoutingDataSource extends AbstractRoutingDataSource {

    private Map<Object, Object> targetDataSources;

    /**
     * 根据Key获取数据源的信息，
     */
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }


    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        if (CollectionUtil.isNotEmpty(this.targetDataSources)) {
            targetDataSources.putAll(targetDataSources);
        }
        super.setTargetDataSources(targetDataSources);
        this.targetDataSources = targetDataSources;
        super.afterPropertiesSet();
    }


}