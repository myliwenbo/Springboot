package vip.xjdai.demo.thread.lock;

/**
 * 死锁演示
 */
public class LockDemo {
    public static void main(String[] args) {
        try {
            LockDemoData dtd1 = new LockDemoData();
            dtd1.setFlag("a");
            new Thread(dtd1).start();
            Thread.sleep(100);
            dtd1.setFlag("b");
            new Thread(dtd1).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class LockDemoData implements Runnable {
    public String username;
    public final Object lock1 = new Object();
    public final Object lock2 = new Object();

    public void setFlag(String username) {
        this.username = username;
    }

    public void run() {
        if (username.equals("a")) {
            synchronized (lock1) {
                try {
                    System.out.println("username = " + username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("按 lock1->lock2代码 顺序执行了");
                }
            }
        }
        if (username.equals("b")) {
            synchronized (lock2) {
                try {
                    System.out.println("username = " + username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("按lock2->lock1代码顺序执行了");
                }
            }
        }
    }
}
