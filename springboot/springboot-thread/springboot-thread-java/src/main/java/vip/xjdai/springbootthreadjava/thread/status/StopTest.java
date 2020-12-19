package vip.xjdai.springbootthreadjava.thread.status;

import com.google.common.collect.Lists;

import java.util.List;

public class StopTest {
    private volatile List<String> list = Lists.newArrayList();
    private static final Object object = new Object();


    public void add() {
        this.list.add("add");
    }

    public int size() {
        return this.list.size();
    }


    public static void main(final String[] args) {
        final StopTest value = new StopTest();
        Thread t1 = new Thread(() -> {
            synchronized (object) {
                for (int i = 0; i < 10; i++) {
                    try {
                        value.add();
                        Thread.sleep(500);
                        if (value.size() == 5) {
                            System.out.println("已发出通知");
                            // 唤醒其他线程，但是并不代表就已经释放了 T1 的拿到的锁
                            // object.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("执行完毕");
        }, "T1");
        Thread t2 = new Thread(() -> {
            synchronized (object) {
                if (value.size() != 5) {
                    try {
                        // 等待，换而言之就是说 如果先拿到锁
                        // 但是 SIZE 长度不是5  则先暂停，并且释放锁
                        object.wait();
                        System.out.println("线程被唤醒....");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();
        t1.start();
    }
}
