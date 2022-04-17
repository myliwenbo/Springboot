package vip.xjdai.springbootweixin.service;

import vip.xjdai.springbootweixin.model.WeChatConfig;

public interface WechatConfigService {

    WeChatConfig queryByAppId(String appId);

}
