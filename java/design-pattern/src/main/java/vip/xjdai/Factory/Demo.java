package vip.xjdai.Factory;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.io.InputStream;

public class Demo {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        defaultSqlSessionFactory.openSession();

    }
}
