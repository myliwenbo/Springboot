package vip.xjdai.springbootthreadjava.threadLocal;

public class ThreadLocalTest {
    static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        stringThreadLocal.set("x");
        stringThreadLocal.remove();
    }
}
