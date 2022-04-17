package vip.xjdai.springbootinitializr.WxDemo;

import org.springframework.stereotype.Component;
import vip.xjdai.springbootinitializr.WxDemo.model.WeChatConfig;

/**
 * @author: 567
 * @date: 2022/2/26
 * @version: 1.0.0
 */
@Component
public class WechatConfigServiceImpl {


    public WeChatConfig queryByAppId(String appIdKey) {
        WeChatConfig WeChatConfig = new WeChatConfig();
        WeChatConfig.setAppSecret("430751edd4aeade89039c9a84fff50bc");
        WeChatConfig.setAppId("wxb3841257f9cc210d");
        WeChatConfig.setUrl("https://qts-h5-dev.relxtech.com/");
        return WeChatConfig;
    }

}
