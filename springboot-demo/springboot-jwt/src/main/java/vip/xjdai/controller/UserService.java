/**
 *
 */
package vip.xjdai.controller;

import java.util.UUID;

import org.springframework.stereotype.Service;

import vip.xjdai.domain.User;

/**
 * @author lwb
 *
 */
@Service
public class UserService {

    public User login(User user) {
        //1. 这里去对user进行校验
        //2. 判断用户是否存在
        //3. 校验密码等...
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setLoginName("xiaoming");
        user.setPassword("123456");
        return user;
    }
}
