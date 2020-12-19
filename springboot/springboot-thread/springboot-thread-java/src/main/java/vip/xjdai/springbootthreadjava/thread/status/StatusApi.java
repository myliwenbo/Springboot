package vip.xjdai.springbootthreadjava.thread.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StatusApi {

    /**
     * 线程状态
     */
    public static class TestInterrupted {
        public static void main(final String[] args) {
            new Thread(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("先执行完毕");
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }, "hhh").start();
            final Map<Thread, StackTraceElement[]> allThread = Thread.getAllStackTraces();
            final List<Thread> ss = new ArrayList<>(allThread.keySet());
            final Boolean[] aBoolean = {true};
            while (aBoolean[0]) {
                ss.forEach((value) -> {
                    if ("hhh".equals(value.getName())) {
                        //测试线程是否已经中断。
                        final Thread.State state = value.getState();
                        if (state.equals(Thread.State.TERMINATED)) {
                            aBoolean[0] = false;
                        }
                    }
                });
            }

            System.out.println("执行完毕");
        }

    }

    public static class TestThreadStatus {
        public static void main(final String[] args) {

        }

    }


    public static class TestSetName {

        public static void main(final String[] args) {
            final Thread thread1 = Thread.currentThread();
            System.out.println(thread1.getName());
            Thread.currentThread().setName("hh");
            System.out.println(thread1.getName());


        }
    }

    public static class TestGetThread {

        public static void main(final String[] args) {
            final Map<Thread, StackTraceElement[]> allThread = Thread.getAllStackTraces();
            final List<Thread> ss = new ArrayList<>(allThread.keySet());
            ss.forEach((value) -> System.out.println(value.getName()));
        }
    }
}
