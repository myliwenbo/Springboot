package vip.xjdai.springbootthreadjava.thread.synchronizeds;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class HasselfPrivateNum2
{
    private Integer number;

    public synchronized void add(final String tag)
    {
        try {
            if (tag.equals("A")) {
                number = 100;
                Thread.sleep(1000);
                System.out.println("A结束");
            } else {
                number = 10;
                Thread.sleep(1000);
                System.out.println("B结束");
            }
            System.out.println(this.number);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
}

@EqualsAndHashCode(callSuper = true)
@Data
class ThreadDemo2 extends Thread
{

    private HasselfPrivateNum2 hasselfPrivateNum;
    private String             userName;

    public ThreadDemo2(final HasselfPrivateNum2 hasselfPrivateNum, final String userName)
    {
        this.hasselfPrivateNum = hasselfPrivateNum;
        this.userName          = userName;
    }

    @Override
    public void run()
    {
        super.run();
        hasselfPrivateNum.add(this.getUserName());
    }

    public static void main(final String[] args)
    {
        final HasselfPrivateNum2 hasselfPrivateNum = new HasselfPrivateNum2();
        final ThreadDemo2        thread1           = new ThreadDemo2(hasselfPrivateNum, "A");
        thread1.start();
        final ThreadDemo2        thread2           = new ThreadDemo2(hasselfPrivateNum, "B");
        thread2.start();
    }
}
