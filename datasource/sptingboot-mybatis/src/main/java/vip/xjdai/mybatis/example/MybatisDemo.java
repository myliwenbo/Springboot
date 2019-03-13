/**
 * 
 */
package vip.xjdai.mybatis.example;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;

import vip.xjdai.springboot.example.domain.User;
import vip.xjdai.springboot.example.mapper.UserMapper;

/**
 * @author lwb
 *
 */
public class MybatisDemo {

    public static void main(String[] args) throws Exception {
        UserMapper getsqlSession = MybatisUtisl.getsqlSession(UserMapper.class);

        Date first = new Date();
        List<User> selectAllUser = getsqlSession.selectAllUser();
        System.out.println(
            "second quest costs:" + (new Date().getTime() - first.getTime()) + " ms");
        String json = JSON.toJSONString(selectAllUser);
        System.out.println(json);
        Date second = new Date();
        UserMapper getsqlSession1 = MybatisUtisl.getsqlSession(UserMapper.class);
        List<User> selectAllUser1 = getsqlSession1.selectAllUser();
        System.out.println(
            "second quest costs:" + (new Date().getTime() - second.getTime()) + " ms");

    }
}
