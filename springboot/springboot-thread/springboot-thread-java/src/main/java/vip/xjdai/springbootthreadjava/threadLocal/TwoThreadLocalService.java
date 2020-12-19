package vip.xjdai.springbootthreadjava.threadLocal;

public class TwoThreadLocalService {


    public void run() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        System.out.println(threadLocal.get());
    }
}
