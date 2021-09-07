package vip.xjdai.phone.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.order.model.User;
import vip.xjdai.order.service.UserService;

@RestController
public class OrderTwoController {

    @Reference(loadbalance = "roundrobin", cluster = "failover", version = "2.0.0")
    private UserService userService;

    @RequestMapping("/getUserTwo")
    public User getUserTwo() {
        //调用服务
        return userService.findUserById((long) 8888);
    }

}