package vip.xjdai.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * 动态切换数据源
 * @author lwb
 *
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {

    /**
     * 根据Key获取数据源的信息，
     */
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }

}