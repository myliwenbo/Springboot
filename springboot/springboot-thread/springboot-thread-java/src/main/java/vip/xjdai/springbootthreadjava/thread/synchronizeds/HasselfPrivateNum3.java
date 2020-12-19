package vip.xjdai.springbootthreadjava.thread.synchronizeds;

import lombok.Data;
import lombok.EqualsAndHashCode;

public class HasselfPrivateNum3
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
class ThreadDemo3 extends Thread
{

    private HasselfPrivateNum3 hasselfPrivateNum;
    private String             userName;

    public ThreadDemo3(HasselfPrivateNum3 hasselfPrivateNum, String userName)
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
        HasselfPrivateNum3 hasselfPrivateNum = new HasselfPrivateNum3();
        ThreadDemo3        thread1           = new ThreadDemo3(hasselfPrivateNum, "A");
        thread1.start();
        ThreadDemo3        thread3           = new ThreadDemo3(hasselfPrivateNum, "B");
        thread3.start();
    }
}
