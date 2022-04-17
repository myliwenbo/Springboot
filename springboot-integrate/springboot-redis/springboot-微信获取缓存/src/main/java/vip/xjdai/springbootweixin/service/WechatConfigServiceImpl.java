package vip.xjdai.springbootweixin.service;

import jdk.nashorn.internal.objects.annotations.Function;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import vip.xjdai.springbootweixin.model.WeChatConfig;

@Component
public class WechatConfigServiceImpl implements WechatConfigService {

    @Override
    public WeChatConfig queryByAppId(String appIdKey) {
        WeChatConfig WeChatConfig = new WeChatConfig();
        WeChatConfig.setAppSecret("430751edd4aeade89039c9a84fff50bc");
        WeChatConfig.setAppId("wxb3841257f9cc210d");
        WeChatConfig.setAppKey("test");
        return WeChatConfig;
    }

}
