
package vip.xjdai.springbootinitializr.WxDemo;

import vip.xjdai.springbootinitializr.WxDemo.model.WechatAuthCheckConfig;

public interface WechatAuthCheckConfigService {

    WechatAuthCheckConfig generateSignature(WechatAuthCheckConfig config);

}
