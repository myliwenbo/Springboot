package vip.xjdai.designpatternsadapter.clazz.demo1;

/**
 * @Project: spring
 * @description: 通过微信接口登录
 * @author: sunkang
 * @create: 2018-09-05 20:58
 * @ModificationHistory who      when       What
 **/
public interface ISiginForWebChat {
    /**
     * 通过微信登录
     *
     * @param openId
     * @return
     */
    ResultMsg loginForWechat(String openId);
}