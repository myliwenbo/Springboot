package vip.xjdai.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

public class Utils {

    private static SqlSession openSession;

    /**
     * 通过传递的xml获取sqlSession会话，Resources.getResourceAsStream("mybatis-config.xml");
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static SqlSession getsession(InputStream inputStream) throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);//通过xml创建会话
        if (openSession == null) {
            openSession = build.openSession();
        }
        return openSession;

    }

    public static void close() throws IOException {
        openSession.close();
    }

    public static void commit() throws IOException {
        openSession.commit();
    }

    /**
     * 通用Mapper，
     *
     * @param type    需要查询的Mapper接口
     * @param xmlFile myBatis配置文件
     * @return 实例化后的
     * @throws Exception
     */
    public static <T> T getsqlSession(Class<T> type, InputStream xmlFile) throws Exception {
        SqlSession openSession = getsession(xmlFile);
        //创建一个MapperHelper
        MapperHelper mapperHelper = new MapperHelper();
        // 注册通用、自己的Mapper接口
        mapperHelper.registerMapper(type);
        //新版的配置
        Config config = new Config();
        mapperHelper.setConfig(config);
        //配置完成后，执行下面的操作
        mapperHelper.processConfiguration(openSession.getConfiguration());
        T mapper = openSession.getMapper(type);
        return mapper;
    }
}
