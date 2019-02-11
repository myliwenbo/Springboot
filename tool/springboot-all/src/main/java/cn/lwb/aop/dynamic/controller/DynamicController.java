package cn.lwb.aop.dynamic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.lwb.aop.dynamic.service.TestService;

/**
 * 动态注入service
 * @author lwb
 *
 */
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
