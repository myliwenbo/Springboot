package vip.xjdai.demo.thread;

/**
 * 异步
 */
public class AsynchronousDemo
{

    public static void main(String[] args)
    {
        Thread t = new Thread()
        {
            public void run()
            {
                try {
                    //休眠1秒
                    sleep(1000)
    ;                //不一定先去处理A方法
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                A();
            }
        };
        t.start();
        B();
    }

    public static void A()
    {
        System.out.println("A方法");
    }

    public static void B()
    {
        System.out.println("B方法");
    }

}
