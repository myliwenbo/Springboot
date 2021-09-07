package vip.xjdai.simplecountdownlatchdemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(11);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始蓄力");
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("蓄力进度：" + finalI);
                countDownLatch.countDown();
                System.out.println("蓄力");
            }).start();
        }
        countDownLatch.countDown();
        countDownLatch.await();
        System.out.println("开始释放界王拳，由于蓄力过久一拳打爆了地球....");
    }
}
