/**
 * 
 */
package vip.xjdai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vip.xjdai.pojo.User;

/**
 * @author lwb
 *
 */
@RestController
@RequestMapping("request")
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient; // 服务发现客户端

    @Autowired
    private Registration    registration;    // 服务注册

    @RequestMapping("getUser")
    public ServiceInstance getUser()
    {
        discoveryClient.description(); //获取描述
        discoveryClient.getInstances(registration.getServiceId());//通过ID获取
        discoveryClient.getServices(); //获取所有服务 ID 列表
        List<ServiceInstance> list = discoveryClient.getInstances(registration.getServiceId());
        for (ServiceInstance si : list) {
            if (si.getPort() == 8081 || si.getPort() == 8082)
                System.out.println(si.getPort());
            return si;
        }
        return null;
    }

    @RequestMapping("getUserOne")
    public String getUserAll(@RequestParam String name)
    {
        return name;
    }

    @RequestMapping("addUserGet")
    public User addUserGet(@RequestParam String name)
    {
        User user = new User();
        user.setName(name);
        return user;
    }

    @RequestMapping("addUserPost")
    public User addUserPost(@RequestBody User user)
    {
        user.setAge("19");
        return user;
    }

}
