package vip.xjdai.springbootmybatisannotation;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.xjdai.springbootmybatisannotation.mapper.UserEntity;
import vip.xjdai.springbootmybatisannotation.mapper.UserMapper;
import vip.xjdai.springbootmybatisannotation.mapper.UserSexEnum;

@SpringBootTest
class SpringbootMybatisAnnotationApplicationTests {

    @Autowired
    private vip.xjdai.springbootmybatisannotation.mapper.UserMapper UserMapper;

    @Test
    public void testInsert() throws Exception
    {
        UserMapper.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));
        UserMapper.insert(new UserEntity("bb", "b123456", UserSexEnum.WOMAN));
        UserMapper.insert(new UserEntity("cc", "b123456", UserSexEnum.WOMAN));
        Assert.assertEquals(3, UserMapper.getAll().size());
    }
}
