package vip.xjdai.springboot.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("mybatis")
public class MybatisController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("mybatis")
    public PageInfo<User> testMapper() {

        for (int i = 0; i < 100; i++) {
            userMapper.insert(new User(i, "小明" + i, "" + i, "" + i));
        }
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(1, 15);
        List<User> users = userMapper.selectAllUser();
        System.out.println(users.size());
        PageInfo<User> pageInfo = new PageInfo<>(users);
        System.out.println(pageInfo.getPageNum());
        System.out.println(pageInfo.getTotal());
        return pageInfo;
    }
}
