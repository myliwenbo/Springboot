package vip.xjdai.springbootquartz.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {

    public static void main(String[] args) {
        test();

    }

    public static void test() {
        System.out.println(TimeUnit.NANOSECONDS.convert(3, TimeUnit.SECONDS));
    }

    public static void delay() {
        // 创建5个订单
        List<String> list = new ArrayList<>();


        //  创建一个队列
        DelayQueue<OrderDelay> queue = new DelayQueue<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            // 将订单添加到队列当中去
            queue.put(new OrderDelay(list.get(i), TimeUnit.NANOSECONDS.convert(3, TimeUnit.SECONDS)));
        }
        // 开启一个线程去跑这些任务
        new Thread(() -> {
            try {
                // 移除队列，等待时间
                queue.take().print();
                System.out.println("After " + (System.currentTimeMillis() - start) + " MilliSeconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


}