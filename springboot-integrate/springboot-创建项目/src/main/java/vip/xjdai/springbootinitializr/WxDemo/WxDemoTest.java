package vip.xjdai.springbootinitializr.WxDemo;

import com.alibaba.fastjson.JSON;
import vip.xjdai.springbootinitializr.WxDemo.model.WechatAuthCheckConfig;

public class WxDemoTest {

    public static void main(String[] args) {
        WechatAuthCheckConfigServiceImpl WechatAuthCheckConfigServiceImpl = new WechatAuthCheckConfigServiceImpl();
        //
        WechatAuthCheckConfig WechatAuthCheckConfig = new WechatAuthCheckConfig();
        WechatAuthCheckConfig wechatAuthCheckConfig = WechatAuthCheckConfigServiceImpl.generateSignature(WechatAuthCheckConfig);
        System.out.println(JSON.toJSONString(wechatAuthCheckConfig));
    }
}
