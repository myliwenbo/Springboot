package vip.xjdai.designpatternsadapter.clazz.demo1;

/**
 * @Project: spring
 * @description: 类适配器   目标接口为ISiginForWebChat，但是适配者的接口为ISiginService
 * @author: sunkang
 * @create: 2018-09-05 21:29
 * @ModificationHistory who      when       What
 **/
public class ClassSiginForWebChatAdapter extends SiginService implements ISiginForWebChat {
    @Override
    public ResultMsg loginForWechat(String openId) {
        return login(openId, null);
    }
}