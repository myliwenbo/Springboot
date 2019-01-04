package vip.xjdai;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vip.xjdai.demo.User;
import vip.xjdai.demo.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SptingbootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads()
    {
        for (int i = 0; i < 100; i++) {
            userMapper.insert(new User(i, "小明" + i, "" + i, "" + i));
        }
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        Page<Object> objects = PageHelper.startPage(1, 15);
        List<User> users = userMapper.selectAllUser();
        System.out.println(users.size());

        PageInfo<User> pageInfo = new PageInfo<>(users);
        System.out.println(pageInfo.getPageNum());
        System.out.println(pageInfo.getTotal());

    }

}
