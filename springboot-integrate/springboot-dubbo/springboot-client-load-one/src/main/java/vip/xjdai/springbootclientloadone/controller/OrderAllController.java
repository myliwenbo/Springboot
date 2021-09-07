package vip.xjdai.springbootclientloadone.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.order.model.User;
import vip.xjdai.order.service.UserService;

@RestController
public class OrderAllController {

    @Reference(loadbalance = "roundrobin", cluster = "failover", version = "*")
    private UserService userService;

    @RequestMapping("/getUserAll")
    public User getUserTwo() {
        //调用服务
        return userService.findUserById((long) 8888);
    }

}