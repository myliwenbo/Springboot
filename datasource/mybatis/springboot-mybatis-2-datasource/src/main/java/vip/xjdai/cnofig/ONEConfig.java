package vip.xjdai.cnofig;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 *  注意，配置类需要对
 *  DataSource、
 *  DataSourceTransactionManager、
 *  SqlSessionFactory 、
 *  SqlSessionTemplate四个数据项进行配置；
 *  DataSource类型需要引入javax.sql.DataSource；
 *  当系统中有多个数据源时，必须有一个数据源为主数据源，使用@Primary修饰。
 *  @MapperScan对指定dao包建立映射，确保在多个数据源下，自动选择合适的数据源，而在service层里不需要做特殊说明。
 */
@Configuration
// / 配置mybatis的接口类放的地方
@MapperScan(basePackages = "vip.xjdai.mapper1", sqlSessionFactoryRef = "oneSqlSessionFactory", sqlSessionTemplateRef = "oneSqlSessionTemplate")
public class ONEConfig
{
    @Bean(name = "oneDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.druid.primary")
    public DataSource dataSource()
    {
        return DruidDataSourceBuilder.create().build();

    }

    /**
     * 生成SqlSessionFactory 需要注入 DataSource
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "oneSqlSessionFactory")
    @Primary // 表示这个数据源是默认数据源
    public SqlSessionFactory sqlSessionFactoryOne(@Qualifier("oneDataSource") DataSource dataSource) throws Exception
    {
        System.out.println("主配");
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        // 加载全局的配置文件，修复驼峰转换问题!
        factoryBean.setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis-config.xml"));
        // 加载特定的mapper.xml映射文件
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/one/*.xml"));
        return factoryBean.getObject();

    }

    /**
     * 事物控制--需要注入datasource
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "oneTransactionManager")
    @Primary // 表示这个数据源是默认数据源
    public DataSourceTransactionManager testTransactionManager(@Qualifier("oneDataSource") DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * spring整合mybatis
     * 需要注入oneSqlSessionFactory
     *
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "oneSqlSessionTemplate")
    @Primary // 表示这个数据源是默认数据源
    public SqlSessionTemplate sqlSessionTemplateOne(
            @Qualifier("oneSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception
    {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }

}
