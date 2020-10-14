package vip.xjdai.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CASTest1 {
    private static final AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> value = new ArrayList<>();
        Runnable runnable = () -> {
            for (int i = 0; i < 5000; i++) {
                atomicInteger.incrementAndGet();
            }
        };
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
            value.add(thread);
        }
        for (Thread thread : value) {
            thread.join();
        }
        System.out.println(atomicInteger.get());
    }


}

