package vip.xjdai.mybatis.api.demo.insert;

import org.junit.jupiter.api.Test;
import vip.xjdai.example.User;
import vip.xjdai.example.UserMapper;
import vip.xjdai.mybatis.api.session.MybatisUtisl;

import java.util.Random;
import java.util.UUID;

public class InsertDemo {

    @Test
    public void insert_1() throws Exception {
        UserMapper userMapperSession = MybatisUtisl.getsqlSession(UserMapper.class);
        for (int i = 0; i < 50; i++) {
            User user = new User();
            user.setUserName("小明" + i);
            user.setPassword(UUID.randomUUID().toString());
            user.setPhone(new Random().nextInt());
            userMapperSession.insert(user);
        }
        MybatisUtisl.commit();
    }
}
