package com.lxg.springboot.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxg.springboot.http.HttpAPIService;

@RestController
@RequestMapping("httpclient")
public class HttpClientController {

    @Resource
    private HttpAPIService httpAPIService;

    @RequestMapping("httpclient")
    public String test() throws Exception {
        String str = httpAPIService.doGet("http://www.baidu.com");
        System.out.println(str);
        return "hello";
    }

    @RequestMapping("retryable")
    public String retryable() throws Exception {
        String str = httpAPIService.doGetRetryable("http://www.baidu.com");
        return "hello";
    }
}
