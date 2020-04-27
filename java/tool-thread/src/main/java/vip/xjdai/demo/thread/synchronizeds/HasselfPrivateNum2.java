package vip.xjdai.demo.thread.synchronizeds;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.xjdai.demo.thread.demo.ThreadDemo;

@Data
public class HasselfPrivateNum2
{
    private Integer number;

    public synchronized void add(String tag)
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
        } catch (InterruptedException e) {
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

    public ThreadDemo2(HasselfPrivateNum2 hasselfPrivateNum, String userName)
    {
        this.hasselfPrivateNum = hasselfPrivateNum;
        this.userName          = userName;
    }

    public void run()
    {
        super.run();
        hasselfPrivateNum.add(this.getUserName());
    }

    public static void main(String[] args)
    {
        HasselfPrivateNum2 hasselfPrivateNum = new HasselfPrivateNum2();
        ThreadDemo2        thread1           = new ThreadDemo2(hasselfPrivateNum, "A");
        thread1.start();
        ThreadDemo2        thread2           = new ThreadDemo2(hasselfPrivateNum, "B");
        thread2.start();
    }
}
