package vip.xjdai.springbootcloudsimpleservice.controller;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
public class TestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String hello(HttpServletRequest httpServletRequest, String name) {
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (StrUtil.isNotBlank(headerNames.nextElement())){
            System.out.println(headerNames.nextElement());
        }
        return name + "=============" + port;
    }
}
