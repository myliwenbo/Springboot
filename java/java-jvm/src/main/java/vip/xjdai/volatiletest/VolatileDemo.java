package vip.xjdai.volatiletest;

import java.util.concurrent.locks.ReentrantLock;

public class VolatileDemo {

    static volatile int i = 1;

    public static void main(String[] args) {
        System.out.println(i);
        ReentrantLock value = new ReentrantLock();
        value.lock();
    }
}
