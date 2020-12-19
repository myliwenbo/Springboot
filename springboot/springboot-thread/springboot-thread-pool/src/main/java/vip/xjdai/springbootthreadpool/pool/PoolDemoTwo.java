package vip.xjdai.springbootthreadpool.pool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class PoolDemoTwo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoll = ThreadPoolUtils.getThreadPoll();
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            threadPoll.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "-----" + finalI);
                try {
                    Thread.sleep(1000);
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

    @Test
    public void cpu() throws Exception {
        int i = Integer.SIZE - 3;
        System.out.println(i);
        int i1 = -1 << i;
        System.out.println(i1);
        System.out.println(i1 | 0);
    }
}
