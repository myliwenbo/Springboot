package vip.xjdai.demo.thread.synchronizeds;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.xjdai.demo.thread.demo.ThreadDemo;

public class HasselfPrivateNum1
{
    public void add(String tag)
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
        } catch (InterruptedException e) {
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

    public ThreadDemo1(HasselfPrivateNum1 hasselfPrivateNum, String userName)
    {
        this.hasselfPrivateNum = hasselfPrivateNum;
        this.userName              = userName;
    }

    public void run()
    {
        hasselfPrivateNum.add(this.getUserName());
    }

    public static void main(String[] args)
    {
        HasselfPrivateNum1 hasselfPrivateNum =new HasselfPrivateNum1();
        ThreadDemo1         thread1           = new ThreadDemo1(hasselfPrivateNum, "A");
        ThreadDemo1         thread2           = new ThreadDemo1(hasselfPrivateNum,"B");
        thread1.start();
        thread2.start();
    }
}
