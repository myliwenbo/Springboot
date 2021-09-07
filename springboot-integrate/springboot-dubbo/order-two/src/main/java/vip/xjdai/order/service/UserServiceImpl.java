package vip.xjdai.order.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import vip.xjdai.order.model.User;

//此处的@Service是dubbo下的注解，不是spring的注解
@Service(version = "2.0.0" ,group = "test")
public class UserServiceImpl implements UserService {

    @Value("${server.port}")
    private String port;


    @Override
    public User findUserById(Long id) {
        User user = new User();
        user.setId(Long.parseLong(port));
        user.setUsername("我是" + id);
        System.out.println("我是2.0");
        System.out.println(id);
        return user;
    }
}