package vip.xjdai.DesignPatterns;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.Reader;

/**
 * 参考： https://mp.weixin.qq.com/s/uwTs45uTztg40leSstGs3g
 */
public class DesignPatternsTest {

    private static SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();

    /**
     * Builder 模式
     *
     * @throws Exception
     */
    @Test
    public void SqlSessionFactoryBuilder() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");// 获取xml地址
        build.build(inputStream);//通过xml创建会话
    }
}
