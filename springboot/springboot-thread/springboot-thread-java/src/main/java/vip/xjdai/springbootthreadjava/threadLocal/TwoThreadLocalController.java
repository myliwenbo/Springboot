package vip.xjdai.springbootthreadjava.threadLocal;

public class TwoThreadLocalController {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("张三");
        TwoThreadLocalService value = new TwoThreadLocalService();
        value.run();
    }
}
