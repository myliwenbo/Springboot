package vip.xjdai.Lock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockDemo {

    static int i = 0;
    static ReentrantLock value = new ReentrantLock(false);


    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        Runnable runnable = () -> {
            for (int j = 0; j < 100000; j++) {
                iAdd();
            }
        };
        for (int j = 0; j < 5; j++) {
            Thread thread = new Thread(runnable);
            thread.start();
            list.add(thread);
        }
        for (Thread thread : list) {
            thread.join();
        }
        System.out.println("jieshu ");

    }

    public static void iAdd() {
        try {
            value.lock();
            i++;
            System.out.println(i);
        } finally {
            value.tryLock();
        }
    }

    @Test
    public void FairSyncTest() throws Exception {

        ReentrantReadWriteLock value = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = value.readLock();
        readLock.lock();
        ReentrantReadWriteLock.WriteLock writeLock = value.writeLock();
        writeLock.lock();

//        ReentrantLock.FairSync value = new ReentrantLock.FairSync();


    }

}
