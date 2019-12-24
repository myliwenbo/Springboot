package vip.xjdai.demo.threadLocal;

import static java.lang.System.*;

public class ThreadLocalDemo
{
    private static ThreadLocal<String> myThreadLocal = new ThreadLocal<>();

    public static void main(String[] args)
    {
       new Thread(){
           @Override
           public void run()
           {
               out.println("我签约");
               super.run();
           }
       }.start();
       new Thread(){
           @Override
           public void run()
           {
               out.println("我签约");
               super.run();
           }
       }.start();


    }
}
