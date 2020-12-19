package vip.xjdai.springbootthreadjava.thread.api;


class IsAlive extends Thread
{

    public void run()
    {
        //测试线程是否是活动状态
        System.out.println(this.isAlive());
    }

    public static void main(String[] args)
    {
        new IsAlive().start();

    }
}

class IsAlive1 extends Thread
{

    public void run()
    {
        //测试线程是否是活动状态
        System.out.println(this.isAlive());
    }

    public static void main(String[] args)
    {
       new Thread(new IsAlive()).start();;

    }
}
