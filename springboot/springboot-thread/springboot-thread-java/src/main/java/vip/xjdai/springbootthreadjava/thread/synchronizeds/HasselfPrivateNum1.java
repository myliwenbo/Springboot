package vip.xjdai.springbootthreadjava.thread.synchronizeds;

import lombok.Data;
import lombok.EqualsAndHashCode;

public class HasselfPrivateNum1
{
    public static void add(final String tag)
    {
        try {
            int number = 0;
            if (tag.equals("A")) {
                number = 100;
                Thread.sleep(1000);
                System.out.println(100 + "结束");
            } else {
                number = 10;
                Thread.sleep(1000);
                System.out.println(10 + "结束");
            }
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
}

@EqualsAndHashCode(callSuper = true)
@Data
class ThreadDemo1 extends Thread
{

    private HasselfPrivateNum1 hasselfPrivateNum;
    private String            userName;

    public ThreadDemo1(final HasselfPrivateNum1 hasselfPrivateNum, final String userName)
    {
        this.hasselfPrivateNum = hasselfPrivateNum;
        this.userName              = userName;
    }

    @Override
    public void run()
    {
        HasselfPrivateNum1.add(this.getUserName());
    }

    public static void main(final String[] args)
    {
        final HasselfPrivateNum1 hasselfPrivateNum =new HasselfPrivateNum1();
        final ThreadDemo1         thread1           = new ThreadDemo1(hasselfPrivateNum, "A");
        final ThreadDemo1         thread2           = new ThreadDemo1(hasselfPrivateNum,"B");
        thread1.start();
        thread2.start();
    }
}
