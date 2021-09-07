package vip.xjdai.springbootclientloadone.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.order.model.User;
import vip.xjdai.order.service.UserService;

@RestController
public class OrderController {

    // 注入要调用的服务
    // random 随机，默认的
    // roundrobin 轮询
    // leastactive //最少活跃
    // consistenthash //一致性Hash
    // @Reference(loadbalance = "roundrobin", version = "2.0", check = false)
    // @Reference(loadbalance = "roundrobin", version = "2.0")
    @Reference(loadbalance = "roundrobin", cluster = "failover", version = "1.0.0")
    private UserService userService;




    @RequestMapping("/getUserOne")
    public User getUserOne() {
        //调用服务
        return userService.findUserById((long) 9999);
    }


}