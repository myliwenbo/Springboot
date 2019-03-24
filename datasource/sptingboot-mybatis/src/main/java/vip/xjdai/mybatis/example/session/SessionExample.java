/**
 * 
 */
package vip.xjdai.mybatis.example.session;

import org.junit.Test;

import vip.xjdai.springboot.example.User;
import vip.xjdai.springboot.example.UserMapper;

/**
 * @author lwb
 *
 */
public class SessionExample {

    /**
     * 不同的Session相同的执行语句也是获取缓存中的数据
     * @throws Exception
     */
    @Test
    public void testname() throws Exception {
        try {
            UserMapper userMapperSession = MybatisUtisl.getsqlSession(UserMapper.class);
            MybatisUtisl.executeSpeed(userMapperSession, "selectAllUser");
            //可以看到二次查询是没有查询数据库的
            MybatisUtisl.executeSpeed(userMapperSession, "selectAllUser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 不同的Session相同的执行语句也是获取缓存中的数据
     * @throws Exception
     */
    @Test
    public void sessionClose() {
        try {
            UserMapper userMapperSession = MybatisUtisl.getsqlSession(UserMapper.class);
            MybatisUtisl.executeSpeed(userMapperSession, "selectAllUser");
            MybatisUtisl.clearCache();
            //可以看到二次查询不是取的缓存而是重新去执行了一次查询
            MybatisUtisl.executeSpeed(userMapperSession, "selectAllUser");
            //可以看到第三次查询是缓存
            MybatisUtisl.executeSpeed(userMapperSession, "selectAllUser");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * 增删改的操作的时候也会影响，
     * @throws Exception
     */
    @Test
    public void sessionUpdate() {
        try {
            UserMapper userMapperSession = MybatisUtisl.getsqlSession(UserMapper.class);
            MybatisUtisl.executeSpeed(userMapperSession, "selectAllUser");
            //可以看到二次查询不是取的缓存
            MybatisUtisl.executeSpeed(userMapperSession, "selectAllUser");
            User user = new User();
            user.setUserId(1);
            user.setPhone("1234567");
            user.setPassword("9999");
            MybatisUtisl.executeSpeed(userMapperSession, "updateByPrimaryKeySelective",
                user, User.class);
            //可以看到三次查询的是数据库
            MybatisUtisl.executeSpeed(userMapperSession, "selectAllUser");
            //可以看到第四次查询是缓存
            MybatisUtisl.executeSpeed(userMapperSession, "selectAllUser");
            MybatisUtisl.commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
