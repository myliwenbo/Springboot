package vip.xjdai.springbootthreadpool.Executors;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsDemo {
    private  Object object=new Object[0];
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 50; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
            Future<?> submit = executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
        }
    }

}
