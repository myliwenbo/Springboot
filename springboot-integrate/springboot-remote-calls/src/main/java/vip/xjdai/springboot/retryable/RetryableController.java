package vip.xjdai.springboot.retryable;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vip.xjdai.springboot.httpclient.HttpAPIService;

@RestController
@RequestMapping("retryable")
public class RetryableController {

    @Resource
    private HttpAPIService httpAPIService;

    @RequestMapping("retryable")
    public String retryable() throws Exception {
        httpAPIService.doGetRetryable("http://www.baidu.com");
        return "hello";
    }
}
