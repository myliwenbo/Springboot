package vip.xjdai.springbootthreadjava.thread.demo;

import java.util.concurrent.atomic.AtomicInteger;

//设计 4 个线程，其中两个线程每次对 j 增加 1，另外两个线程对 j 每次减少 1。
public class Test_1 {

    public static void main(String[] args) {
        AtomicInteger j = new AtomicInteger(2);
        new Thread(() -> {
            for (int i = 0; i < j.get(); i++) {
                j.getAndIncrement();
                System.out.println(Thread.currentThread().getName() + "第1个循环");
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < j.get(); i++) {
                j.getAndIncrement();
                System.out.println(Thread.currentThread().getName() + "第2个循环");
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < j.get(); i++) {
                j.getAndDecrement();
                System.out.println(Thread.currentThread().getName() + "第3个循环");
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < j.get(); i++) {
                j.getAndDecrement();
                System.out.println(Thread.currentThread().getName() + "第4个循环");
            }
        }).start();

    }
}
