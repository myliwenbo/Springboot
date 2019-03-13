/**
 * 
 */
package vip.xjdai.mybatis.example;

import org.junit.Test;

import vip.xjdai.springboot.example.mapper.UserMapper;

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
        UserMapper userMapperSession = MybatisUtisl.getsqlSession(UserMapper.class);
        MybatisUtisl.executeSpeed(userMapperSession);
        MybatisUtisl.executeSpeed(userMapperSession);
    }

}
