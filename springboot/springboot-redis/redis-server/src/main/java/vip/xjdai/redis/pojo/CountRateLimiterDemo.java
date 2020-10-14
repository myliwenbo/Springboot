package vip.xjdai.redis.pojo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CountRateLimiterDemo {

    private static Semaphore semphore = new Semaphore(50);

    public static void exec() {
        if (semphore.getQueueLength() > 100) {
            System.out.println("当前等待排队的任务数大于100，请稍候再试...");
        }
        try {
            semphore.acquire();
            // 处理核心逻辑  
            TimeUnit.SECONDS.sleep(1);
            System.out.println("--" + System.currentTimeMillis() / 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semphore.release();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 30; j++) {
                    exec();
                }
            }).start();
        }
    }
}  
