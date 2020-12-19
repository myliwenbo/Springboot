package vip.xjdai.springbootthreadjava.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> value = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 5000; j++) {
                    atomicInteger.incrementAndGet();
                }
            });
            thread.start();
            value.add(thread);
        }
        for (Thread thread : value) {
            thread.join();
        }
        System.out.println(atomicInteger.get());
    }
}
