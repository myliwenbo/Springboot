package vip.xjdai.demo.thread.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreadListTest {

    public static void main(String[] args) throws InterruptedException {
        add();
        Thread.sleep(0xf4240);
    }

    private static void add() {
        List<Integer> list = new ArrayList<>();
        new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                list.add(i);
            }
        }).start();
        new Thread(() -> {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }).start();


    }
}
