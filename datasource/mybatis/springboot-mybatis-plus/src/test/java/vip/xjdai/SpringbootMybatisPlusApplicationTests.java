package vip.xjdai;

import com.alibaba.druid.support.json.JSONUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.xjdai.mapper.UserMapper;
import vip.xjdai.model.User;

import java.util.List;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests
{

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
    System.out.println(("----- selectAll method test ------"));
    List< User > userList = userMapper.selectList(null);
    userList.forEach(System.out::println);
}
}
