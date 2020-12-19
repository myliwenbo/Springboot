package vip.xjdai.springbootthreadjava.thread.demo;

import java.util.concurrent.CountDownLatch;

/**
 * 并发演示
 */
public class ThreadComplicating extends Thread
{
    private static int            BINGFA = 50;
    private static CountDownLatch cdl    = new CountDownLatch(BINGFA);

    public void run()
    {

    }

    public static void main(String[] args) throws Exception
    {
        ThreadComplicating t1 = new ThreadComplicating();
        for (int i = 0; i < BINGFA; i++) {
            Thread thread = new Thread(()->{
                try {
                    cdl.await(); //阻塞等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("开始跟：" + Thread.currentThread().getName() + "聊天");
            });
            String name = i % 2 == 0 ?
                    "甲" :
                    "乙";
            thread.setName(name);
            thread.start();
            cdl.countDown();  //计数器- 1，当计数为0的时候同时执行
            System.out.println("执行了"+i);
        }
    }
}
