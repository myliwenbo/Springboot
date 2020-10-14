package vip.xjdai.demo.complicating;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //CyclicBarrier  的计数器更像一个阀门，需要所有线程都到达，然后继续执行
        CyclicBarrier cyclicBarrier = new CyclicBarrier(100);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    cyclicBarrier.await();//当所有线程执行完毕
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程执行了" + finalI);
            }).start();
            System.out.println(i);
        }
    }
}
