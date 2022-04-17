package vip.xjdai.springbootweixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.springbootweixin.model.WechatAuthCheckConfig;
import vip.xjdai.springbootweixin.service.WechatAuthCheckConfigServiceImpl;
import vip.xjdai.springbootweixin.service.WechatConfigService;
import vip.xjdai.springbootweixin.service.WechatConfigServiceImpl;

@RestController
@RequestMapping("Test")
public class Test {
    @Autowired
    private WechatAuthCheckConfigServiceImpl wechatAuthCheckConfigService;

    @RequestMapping("test")
    public void test() {
        WechatAuthCheckConfig wechatAuthCheckConfig = new WechatAuthCheckConfig();
        wechatAuthCheckConfig.setUrl("https://qts-h5-dev.relxtech.com/");
        wechatAuthCheckConfig.setAppKey("test");
        wechatAuthCheckConfigService.generateSignature(wechatAuthCheckConfig);
    }
}
