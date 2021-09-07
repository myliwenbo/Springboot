package vip.xjdai.simplejavademo.test;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class TestMQ {

    public static void main(String[] args) {
        TestQueue value = new TestQueue(5);
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                value.put(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(() -> {
            while (true) {
                Object tick = value.tick();
                System.out.println(tick);
            }
        }).start();
    }
}

class TestQueue {

    private final LinkedList<Object> list = Lists.newLinkedList();

    private final Object lock = new Object();

    private final AtomicInteger atomicInteger = new AtomicInteger(0);
    // 队列的最大值
    private final Integer maxSize;
    // 队列的最小值
    private Integer minSize = 0;

    public TestQueue(Integer maxSize) {
        this.maxSize = maxSize;
    }

    @SneakyThrows
    public void put(Object o) {
        synchronized (this.lock) {
            // 如果 计数器 > 最大值
            if (this.atomicInteger.get() == this.maxSize) {
                // 进行暂停线程，
                this.lock.wait();

            }
            this.list.add(o);
            //+1
            this.atomicInteger.incrementAndGet();
            System.out.println("添加一个元素");
            // 唤醒 其他线程
            this.lock.notify();
        }

    }

    @SneakyThrows
    public Object tick() {
        synchronized (this.lock) {
            // 如果已经是最小值了则进行暂停操作...
            if (this.minSize == this.atomicInteger.get()) {
                // 进行暂停线程，并且释放锁，执行到这里代码就不会往下执行了
                System.out.println("tick 开始暂停...");
                this.lock.wait();
                System.out.println("tick 开始执行...");
            }
            //弹出头 一个
            Object o = this.list.removeFirst();
            // -1
            this.atomicInteger.decrementAndGet();
            // 唤醒其他线程..
            this.lock.notify();
            return o;
        }
    }
}
