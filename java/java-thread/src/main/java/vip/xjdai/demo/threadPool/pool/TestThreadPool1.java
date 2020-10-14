package vip.xjdai.demo.threadPool.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool1 {


    public static void main(String[] args) {
        ExecutorService fixedExecutor = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            final int index = i;
            //执行线程任务
            fixedExecutor.execute(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " index:" + index);
            });
        }
        fixedExecutor.shutdown();//关闭线程池
    }

}