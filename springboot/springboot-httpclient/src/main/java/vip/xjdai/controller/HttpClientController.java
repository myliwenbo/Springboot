package vip.xjdai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.http.HttpAPIService;

import javax.annotation.Resource;

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
