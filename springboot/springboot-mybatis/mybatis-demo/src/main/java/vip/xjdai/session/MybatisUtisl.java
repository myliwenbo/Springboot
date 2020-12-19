/**
 *
 */
package vip.xjdai.session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import vip.xjdai.example.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author lwb
 *
 */
public class MybatisUtisl
{

    public static SqlSession openSession;

    /**
     * 通过传递的xml获取sqlSession会话，Resources.getResourceAsStream("mybatis-config.xml");
     * @return
     * @throws IOException
     */
    public static SqlSession getsession() throws IOException
    {
        InputStream       inputStream = Resources.getResourceAsStream("mybatis.xml");// 获取xml地址
        SqlSessionFactory build       = new SqlSessionFactoryBuilder().build(inputStream);//通过xml创建会话
        if (openSession == null) {
            openSession = build.openSession();
        }
        return openSession;

    }

    public static void close()
    {
        openSession.close();
    }

    /**
     * 清楚缓存
     */
    public static void clearCache()
    {
        openSession.clearCache();
    }

    public static < T > T getsqlSession(Class< T > type) throws Exception
    {
        SqlSession openSession = getsession();// 获取会话
        T          mapper      = openSession.getMapper(type);// 放入接口获取实现对象
        return mapper;
    }

    public static void executeSpeed(UserMapper getsqlSession, String methodName) throws Exception
    {
        executeSpeed(getsqlSession, methodName, null);
    }

    public static void executeSpeed(UserMapper getsqlSession, String methodName, Object args,
                                    Class< ? >... parameterTypes) throws Exception
    {
        Date                          first = new Date();
        Class< ? extends UserMapper > clazz = getsqlSession.getClass();
        Method                        method;
        if (parameterTypes == null) {
            method = clazz.getMethod(methodName);
        } else {
            method = clazz.getMethod(methodName, parameterTypes);
        }
        Object invoke;
        if (args == null) {
            invoke = method.invoke(getsqlSession);
        } else {
            invoke = method.invoke(getsqlSession, args);
        }
        System.out.println(invoke.toString());
        System.out.println("获取时间:" + (new Date().getTime() - first.getTime()) + " ms");
    }

    public static void commit()
    {
        openSession.commit();
    }

}
