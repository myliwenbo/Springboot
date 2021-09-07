package vip.xjdai.springbootlock.ReentrantLock;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) {
        ReentrantLockDemo value = new ReentrantLockDemo();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                reentrantLock.lock();
                value.serviceAddOrder();
                reentrantLock.unlock();
            }).start();
        }


    }

    @SneakyThrows
    public void serviceAddOrder() {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"：执行了");

    }
}
