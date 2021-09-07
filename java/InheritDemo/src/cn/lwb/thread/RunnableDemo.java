/**
 * 
 */
package cn.lwb.thread;

/**
 * @author lwb
 *
 */
public class RunnableDemo implements Runnable {

    @Override
    public void run()
    {
        try {
            Thread.sleep(6000L);
            System.out.println("我最后执行!!!!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
