package vip.xjdai.springbootthreadcountdownlatch;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    CountDownLatch countDownLatch = new CountDownLatch(10);

    public void run() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 99, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(99));
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    this.countDownLatch.countDown();
                    this.countDownLatch.await();
                } catch (InterruptedException e) {
                    System.out.println("蓄力失败");
                }
                System.out.println("界王拳");
            });
            System.out.println("蓄力中：" + i);
        }
    }

    public static void main(String[] args) {
        CountDownLatchTest value = new CountDownLatchTest();
        value.run();
    }
}
