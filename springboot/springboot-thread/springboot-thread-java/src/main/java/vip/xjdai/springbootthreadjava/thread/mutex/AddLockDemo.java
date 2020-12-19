package vip.xjdai.springbootthreadjava.thread.mutex;

public class AddLockDemo {


    private static Object lock = new Object(); // static确保只有一把锁
    private int i = 0;
    public void increaseI() {
        synchronized (lock) {
            for(int k=0;k<10;k++) {  // 对i执行10次增1操作
                i++;
            }
            System.out.println(Thread.currentThread().getName() + "线程，i现在的值：" + i);
        }
    }



    public static void main(String[] args) {

        LockDemo ld = new LockDemo();
        int threadNum = 1000;   // 选择1000个线程让结果更加容易观测到
        AddMyThread[] threads = new AddMyThread[threadNum];
        for(int i=0;i<threads.length;i++) {
            threads[i] = new AddMyThread(ld);  // 所有线程共用一个LockDemo对象
            threads[i].start();
        }



    }



}



class AddMyThread extends Thread {
    LockDemo ld;

    public AddMyThread(LockDemo ld) {
        this.ld = ld;
    }
    public void run() {
        ld.increaseI();
    }
}
