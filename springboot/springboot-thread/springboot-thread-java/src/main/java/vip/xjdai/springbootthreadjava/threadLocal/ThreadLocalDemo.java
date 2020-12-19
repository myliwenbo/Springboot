package vip.xjdai.springbootthreadjava.threadLocal;

import static java.lang.System.*;

public class ThreadLocalDemo
{
    private static ThreadLocal<String> myThreadLocal = new ThreadLocal<>();

    public static void main(String[] args)
    {
        myThreadLocal.set("张三");
        myThreadLocal.get();
    }
}
