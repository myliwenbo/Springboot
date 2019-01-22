package cn.lwb.annotation.dynamic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.lwb.annotation.dynamic.service.TestService;

@RestController
@RequestMapping("dynamicController")
public class DynamicController {

    private TestService testServiceImpl;

    @RequestMapping("dynamic")
    public String dynamic(String name) {
        String whoAmI = testServiceImpl.whoAmI();
        return whoAmI;
    }
}
