package vip.xjdai.designpatternsadapter.clazz.demo1;

/**
 * @Project: spring
 * @description:   登录的接口业务
 * @author: sunkang
 * @create: 2018-09-05 20:51
 * @ModificationHistory who      when       What
 **/
public interface ISiginSerevice {
    ResultMsg login(String username, String password);
}