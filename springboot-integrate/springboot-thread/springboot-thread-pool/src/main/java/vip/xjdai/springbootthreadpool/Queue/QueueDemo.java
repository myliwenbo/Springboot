package vip.xjdai.springbootthreadpool.Queue;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class QueueDemo {

    public static class ArrayBlockingQueueDemo {
        private static final Object lock = new Object();

        public static void main(String[] args) throws InterruptedException {
            ArrayBlockingQueue<Integer> value = new ArrayBlockingQueue<>(10);
            new Thread(() -> {
                for (int i = 0; i < 110; i++) {
                    try {
                        if (value.size() != 10) {
                            value.put(i);
                            System.out.println("添加值为：" + i);
                        } else {
                            synchronized (lock) {
                                lock.notify();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(() -> {
                try {
                    synchronized (lock) {
                        while (true) {
                            if (value.size() == 0) {
                                lock.wait();
                            }
                            if (value.size() != 0) {
                                Integer poll = value.poll();
                                System.out.println("取出值为：" + poll);
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }


    public static class LinkedBlockingQueueDemo {

        public static void main(String[] args) {
            LinkedBlockingQueue value = new LinkedBlockingQueue(10);
            for (int i = 0; i < 1000; i++) {
                value.add(i);
                System.out.println("添加值为：" + i);
            }
        }
    }
}
