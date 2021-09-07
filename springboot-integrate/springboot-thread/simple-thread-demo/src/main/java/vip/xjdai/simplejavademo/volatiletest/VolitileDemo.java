package vip.xjdai.simplejavademo.volatiletest;

public class VolitileDemo {

    static int i = 0;
    static boolean tag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (tag) {
                ++i;
            }
        }, "线程1").start();
        Thread.sleep(100);
        new Thread(() -> {
            tag = false;
            while (true) {
//                int b= i;
            }
        }, "线程2").start();
    }
}
