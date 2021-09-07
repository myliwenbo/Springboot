package vip.xjdai.springbootqueueblocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueue {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> strings = new ConcurrentLinkedQueue<>();
        strings.add("123");
        strings.offer("456");
        // 有界队列，底层是数据
        ArrayBlockingQueue<String> strings1 = new ArrayBlockingQueue<>(10);
        strings1.add("123");

        // 有界队列，底层是链表，
        LinkedBlockingQueue<String> strings2 = new LinkedBlockingQueue<>(10);
        strings2.add("132");
        PriorityBlockingQueue<String> value = new PriorityBlockingQueue<>();
    }
}
