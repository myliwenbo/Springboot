package vip.xjdai.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置数据源
 *
 * @author lwb
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "proDataSource")
    @ConfigurationProperties("spring.datasource.pro")
    public DataSource proDataSource() {
        return DruidDataSourceBuilder.create().build();

    }

    @Bean(name = "minorOneDataSource")
    @ConfigurationProperties("spring.datasource.minor-one")
    public DataSource minorOneDataSource() {
        return DruidDataSourceBuilder.create().build();

    }

    @Bean(name = "minorTwoDataSource")
    @ConfigurationProperties("spring.datasource.minor-two")
    public DataSource minorTwoDataSource() {
        return DruidDataSourceBuilder.create().build();

    }

    @Bean("myRoutingDataSource")
    public DataSource myRoutingDataSource(@Qualifier("proDataSource") DataSource proDataSource,
                                          @Qualifier("minorOneDataSource") DataSource minorOneDataSource,
                                          @Qualifier("minorTwoDataSource") DataSource minorTwoDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.MASTER, proDataSource);
        targetDataSources.put(DBTypeEnum.MINOR_TWO, minorOneDataSource);
        targetDataSources.put(DBTypeEnum.MINOR_ONE, minorTwoDataSource);
        //动态切换数据源
        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
        //设置默认的数据源
        myRoutingDataSource.setDefaultTargetDataSource(proDataSource);
        //设置所有数据源
        myRoutingDataSource.setTargetDataSources(targetDataSources);
        return myRoutingDataSource;
    }

}
