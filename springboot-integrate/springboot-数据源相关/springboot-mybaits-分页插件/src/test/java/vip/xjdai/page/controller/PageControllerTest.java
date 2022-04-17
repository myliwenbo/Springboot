package vip.xjdai.page.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.xjdai.page.mapper.User;
import vip.xjdai.page.mapper.UserMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PageControllerTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public PageInfo<User> testMapper() {
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