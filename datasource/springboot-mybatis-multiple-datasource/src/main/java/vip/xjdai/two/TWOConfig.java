package vip.xjdai.two;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = { "vip.xjdai" }, sqlSessionFactoryRef = "twoSqlSessionFactory", sqlSessionTemplateRef = "twoSqlSessionTemplate")
public class TWOConfig {
    @Value("${spring.datasource.minor.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.minor.url}")
    private String url;

    @Value("${spring.datasource.minor.username}")
    private String username;

    @Value("${spring.datasource.minor.password}")
    private String password;

    @Bean(name = "twoDataSource")
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
    @Bean(name = "twoSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryOne(@Qualifier("twoDataSource") DataSource dataSource) throws Exception {
        System.out.println("不是主配");
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        // /*加载所有的mapper.xml映射文件*/
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
            .getResources("classpath:mapper/two/*.xml"));
        return factoryBean.getObject();

    }

    /**
     * 事物控制
     */
    @Bean(name = "twoTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("twoDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * spring整合mybatis
     */
    @Bean(name = "twoSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplateOne(@Qualifier("twoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }

}
