package vip.xjdai.simplevolatiledemo;

import java.util.concurrent.CountDownLatch;

public class CountdownLatch {

    static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    System.out.println("蓄力中：" + finalI);
                    countDownLatch.countDown();
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("界王拳");
            }).start();
        }
    }
}
