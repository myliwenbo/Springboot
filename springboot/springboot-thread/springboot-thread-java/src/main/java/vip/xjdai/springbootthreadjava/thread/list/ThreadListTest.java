package vip.xjdai.springbootthreadjava.thread.list;


import java.util.ArrayList;
import java.util.List;

public class ThreadListTest {

    public static void main(final String[] args) throws InterruptedException {
        add();
    }

    private static void add() throws InterruptedException {
        final List<Integer> list = new ArrayList<>();
        new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                list.add(i);
            }
        }, "t1").start();
        Thread.sleep(1000);
        new Thread(() -> {
            for (final Integer integer : list) {
                System.out.println(integer);
            }
        }, "t2").start();


    }
}
