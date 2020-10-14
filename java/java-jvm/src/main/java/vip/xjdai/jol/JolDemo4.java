package vip.xjdai.jol;

import org.openjdk.jol.info.ClassLayout;

public class JolDemo4 {


    public static void main(String[] args) throws InterruptedException {
        Object value2 = new Object();
        System.out.println(ClassLayout.parseInstance(value2).toPrintable());
        synchronized (value2) {
            System.out.println(ClassLayout.parseInstance(value2).toPrintable());
        }
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                synchronized (value2) {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(ClassLayout.parseInstance(value2).toPrintable());
                }
            }).start();
        }

    }

}
