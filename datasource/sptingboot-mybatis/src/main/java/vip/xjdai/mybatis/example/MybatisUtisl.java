/**
 * 
 */
package vip.xjdai.mybatis.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vip.xjdai.springboot.example.domain.User;
import vip.xjdai.springboot.example.mapper.UserMapper;

/**
 * @author lwb
 *
 */
public class MybatisUtisl {

    public static SqlSession openSession;

    /**
     * 通过传递的xml获取sqlSession会话，Resources.getResourceAsStream("mybatis-config.xml");
     * @return
     * @throws IOException
     */
    public static SqlSession getsession() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");// 获取xml地址
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);//通过xml创建会话
        if (openSession == null) {
            openSession = build.openSession();
        }
        return openSession;

    }

    public static <T> T getsqlSession(Class<T> type) throws Exception {
        SqlSession openSession = getsession();// 获取会话
        T mapper = openSession.getMapper(type);// 放入接口获取实现对象
        return mapper;
    }

    public static void executeSpeed(UserMapper getsqlSession) {
        Date first = new Date();
        List<User> selectAllUser = getsqlSession.selectAllUser();
        System.out.println("获取时间:" + (new Date().getTime() - first.getTime()) + " ms");
    }

}
