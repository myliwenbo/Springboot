package vip.xjdai.springbootthreadjava.thread.synchronizeds;

import lombok.Data;
import lombok.EqualsAndHashCode;

public class ThreadSynchronizedsMethod1
{

    public synchronized void methodA()
    {
        try {
            Thread.sleep(1000);
            System.out.println("开始 线程名称" + Thread.currentThread().getName());
            System.out.println("结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodB()
    {
        try {
            System.out.println("开始 线程名称" + Thread.currentThread().getName());
            System.out.println("结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        ThreadSynchronizedsMethod1 threadSynchronizedsMethod1 = new ThreadSynchronizedsMethod1();
        ThreadSynchronizeds1 threadSynchronizeds1 = new ThreadSynchronizeds1(threadSynchronizedsMethod1, "A");
        threadSynchronizeds1.start();
        ThreadSynchronizeds1 threadSynchronizeds2 = new ThreadSynchronizeds1(threadSynchronizedsMethod1, "B");
        threadSynchronizeds2.start();

    }
}

@EqualsAndHashCode(callSuper = true)
@Data
class ThreadSynchronizeds1 extends Thread
{
    private ThreadSynchronizedsMethod1 threadSynchronizedsMethod1;

    private String tag;

    public ThreadSynchronizeds1(ThreadSynchronizedsMethod1 threadSynchronizedsMethod1, String name)
    {
        this.threadSynchronizedsMethod1 = threadSynchronizedsMethod1;
        this.setName(name);
        this.tag = name;
    }

    public void run()
    {
        if (tag.equals("A")) {
            threadSynchronizedsMethod1.methodA();
        } else{
            threadSynchronizedsMethod1.methodB();
        }
    }
}