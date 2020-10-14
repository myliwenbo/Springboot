package vip.xjdai.demo.thread.status;

/**
 * 阻塞演示
 */
public class BlockingStatus {


    public synchronized void test() {
        //要执行好久
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        BlockingStatus blockingStatus = new BlockingStatus();
        for (int i = 0; i < 1000; i++) {
            new Thread(blockingStatus::test).start();
        }
    }


}
