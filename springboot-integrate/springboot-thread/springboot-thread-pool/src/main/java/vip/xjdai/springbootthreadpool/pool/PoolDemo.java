package vip.xjdai.springbootthreadpool.pool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                10000,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "-----" + finalI);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }

    @Test
    public void cpu_number() throws Exception {
        // 获取CPU 核心数量
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
