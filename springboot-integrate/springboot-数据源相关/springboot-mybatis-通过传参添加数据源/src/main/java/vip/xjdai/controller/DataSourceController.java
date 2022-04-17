/**
 *
 */
package vip.xjdai.controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.config.DBContextHolder;
import vip.xjdai.config.DBTypeEnum;
import vip.xjdai.config.MyRoutingDataSource;
import vip.xjdai.dao.MySQLGeneratorDao;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lwb
 *
 */
@RestController
@RequestMapping("dataSource")
public class DataSourceController implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Autowired
    private MySQLGeneratorDao mySQLGeneratorDao;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    /**
     * 这里为核心代码
     * @return
     */
    @RequestMapping("add")
    public String add() {
        // 1. 添加到数据库
        // 2. 添加到数据源当中
        // 3. 添加到一个枚举中
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.117.128:3306/mysql-demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&pinGlobalTxToPhysicalConnection=true&autoReconnect=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        MyRoutingDataSource bean = (MyRoutingDataSource) applicationContext.getBean("myRoutingDataSource");
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.CUSTOMIZE, dataSource);
        bean.setTargetDataSources(targetDataSources);
        return "OK";
    }

    @RequestMapping("select")
    public String select() {
        // 通过传递的参数来获取不同的数据源
        DBContextHolder.set(DBTypeEnum.CUSTOMIZE);
        mySQLGeneratorDao.queryList();
        return "OK";
    }
}
