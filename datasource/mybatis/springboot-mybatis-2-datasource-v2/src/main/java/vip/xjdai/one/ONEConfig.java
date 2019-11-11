package vip.xjdai.one;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 注意，配置类需要对
 *          DataSource 数据源 <br/>
 *          DataSourceTransactionManager 事物管理器<br/>
 *          SqlSessionFactory mybatis工厂<br/>
 *          SqlSessionTemplate MyBatis-Spring管理SqlSession <br>
 * @author lwb
 *
 */
@Configuration
// / 配置mybatis的接口类放的地方
@MapperScan(basePackages = "vip.xjdai.one", sqlSessionFactoryRef = "oneSqlSessionFactory", sqlSessionTemplateRef = "oneSqlSessionTemplate")
public class ONEConfig {

    @Value("${spring.datasource.primary.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.primary.url}")
    private String url;

    @Value("${spring.datasource.primary.username}")
    private String username;

    @Value("${spring.datasource.primary.password}")
    private String password;

    @Bean(name = "oneDataSource")
    @Primary //用于配置默认数据源，切记只有主数据源才配置，其他数据源不用配置
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(this.driverClassName);
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        return dataSource;
    }

    /**
     * 生成SqlSessionFactory 需要注入 DataSource
     */
    @Bean(name = "oneSqlSessionFactory")
    @Primary //用于配置默认数据源，切记只有主数据源才配置，其他数据源不用配置
    public SqlSessionFactory sqlSessionFactoryOne(@Qualifier("oneDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //加载mybatis配置文件
        factoryBean.setConfigLocation(new DefaultResourceLoader()
            .getResource("classpath:mybatis/mybatis-config.xml"));
        // 加载特定的mapper.xml映射文件
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
            .getResources("classpath:mybatis/mapper/*.xml"));
        return factoryBean.getObject();

    }

    /**
     * 事物控制--需要注入datasource
     */
    @Bean(name = "oneTransactionManager")
    @Primary //用于配置默认数据源，切记只有主数据源才配置，其他数据源不用配置
    public DataSourceTransactionManager testTransactionManager(@Qualifier("oneDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * spring整合mybatis
     * 需要注入oneSqlSessionFactory
     */
    @Bean(name = "oneSqlSessionTemplate")
    @Primary //用于配置默认数据源，切记只有主数据源才配置，其他数据源不用配置
    public SqlSessionTemplate sqlSessionTemplateOne(@Qualifier("oneSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }

}
