package vip.xjdai.designpatternsadapter.clazz.demo1;

public class SiginService implements ISiginSerevice {
    /**
     * 登录的方法
     *
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username, String password) {
        return new ResultMsg("200", "登录成功", new Object());
    }
}