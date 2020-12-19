package vip.xjdai.springbootthreadjava.thread.mutex;
//没有互斥锁的情况（可以自己跑跑看运行结果）：

public class LockDemo {

    private int i = 0;

    public void increaseI() {
        for (int k = 0; k < 10; k++) {  // 对i执行10次增1操作
            i++;
        }
        System.out.println(Thread.currentThread().getName() + "线程，i现在的值：" + i);

    }


    public static void main(String[] args) {
        LockDemo ld = new LockDemo();
        int threadNum = 100;   // 选择1000个线程让结果更加容易观测到
        MyThread[] threads = new MyThread[threadNum];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(ld);  // 所有线程共用一个LockDemo对象
            threads[i].start();
        }
    }


}


class MyThread extends Thread {

    LockDemo ld;
    public MyThread(LockDemo ld) {
        this.ld = ld;
    }

    public void run() {
        ld.increaseI();
    }

}

