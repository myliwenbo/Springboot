package vip.xjdai.volatiletest;

import sun.misc.Unsafe;

public class VolatileInvisible {

    static volatile int i = 0;
    static boolean tag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("后执行");
            for (long j = 0; j < 1000_0000_0000_0000L; j++) {
                i++;
            }
        }).start();
        Thread.sleep(0x3e8);
        new Thread(() -> {
            tag = false;
            System.out.println("先执行");
        }).start();
        System.out.println(i);
    }
}
