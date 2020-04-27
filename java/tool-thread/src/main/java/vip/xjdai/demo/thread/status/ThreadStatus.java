package vip.xjdai.demo.thread.status;

public class ThreadStatus {

    public static void main(String[] args) throws Exception {
        new ThreadStatus().threadTest5();
    }


    /**
     * 初始化状态，没调用 start前
     *
     * @throws Exception
     */
    public void threadTest1() throws Exception {

        Thread t = new Thread(() -> {
            System.out.println("线程状态");
        });
    }

    /**
     * 就绪状态，等待JVM分配线程的时候
     *
     * @throws Exception
     */
    public void threadTest2() throws Exception {

        Thread t = new Thread(() -> {
            System.out.println("线程状态");
        });
        t.start();
    }

    /**
     * 启动状态，JVM已经分配了资源
     *
     * @throws Exception
     */
    public void threadTest3() throws Exception {

        Thread t = new Thread(() -> {
            System.out.println("线程状态");
        });
        t.start();
    }

    /**
     * 休眠状态：线程已经启动，但是出于休眠，等休眠到了便会执行，此时CPU执行权还在线程手里
     *
     * @throws Exception
     */
    public void threadTest4() throws Exception {

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程状态");
        });
        t.start();
    }

    /**
     * 暂停状态，暂停状态需要
     *
     * @throws Exception
     */
    public void threadTest5() throws Exception {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("执行：" + i);
            }
        });
        thread.start();
        synchronized (this) {
            thread.wait();
        }
    }


}
