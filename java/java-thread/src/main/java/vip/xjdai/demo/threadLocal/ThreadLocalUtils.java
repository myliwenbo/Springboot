package vip.xjdai.demo.threadLocal;

public class ThreadLocalUtils {
    private final static ThreadLocal<User> local;

    static {
        local = new ThreadLocal<>();
    }

    public static User get() {
        return local.get();
    }


    public static void set(User user) {
        local.set(user);
    }

}
