/**
 * 
 */
package cn.lwb.thread;

/**
 * @author lwb
 *
 */
public class Demo {

    public static void main(String[] args)
    {
        Runnable runnableDemo = new RunnableDemo();
        Thread t1 = new Thread(runnableDemo);
        t1.start();
        System.out.println("我先执行!!!!!!");

    }
}
