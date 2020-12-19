package vip.xjdai.springbootthreadjava.thread.status;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;

import java.util.List;

public class ThreadStatusTest {

    /**
     * 新建状态
     */
    public static class NewTest {
        public static void main(String[] args) {
            Thread thread = new Thread(() -> {
                System.out.println("我尚未执行...");
            });
            Thread.State state = thread.getState();
            System.out.println(state);
        }
    }

    /**
     * 就绪状态
     */
    public static class RunnableTest {

        public static void main(String[] args) {
            Thread t1 = new Thread(RunnableTest::test);
            t1.start();
            Thread t2 = new Thread(RunnableTest::test);
            t2.start();
            System.out.println(t2.getState());

        }

        @SneakyThrows
        public synchronized static void test() {
            Thread.sleep(10000);
        }

    }

    public static class StopTest {

        public static void main(String[] args) throws InterruptedException {
            Thread thread = new Thread(() -> {
                System.out.println("执行完毕");
            });
            thread.start();
            Thread.sleep(100);
            System.out.println(thread.getState());
        }
    }

    public static class WaitTest {

        private static final Object lock = new Object();

        public static void main(String[] args) throws InterruptedException {
            Thread thread = new Thread(() -> {
                try {
                    synchronized (lock) {
                        lock.wait(); //等待中..
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            Thread.sleep(100);
            System.out.println(thread.getState());
        }
    }

    public static class TimeWaitTest {

        private static final Object lock = new Object();

        public static void main(String[] args) throws InterruptedException {
            Thread thread = new Thread(() -> {
                try {
                    synchronized (lock) {
                        //等待1000后执行..
                        lock.wait(1000);
                        System.out.println("执行了.");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            Thread.sleep(100);
            System.out.println(thread.getState());
        }
    }

    public static class BlockedTest {


        public static void main(String[] args) throws InterruptedException {
            List<Thread> threads = Lists.newArrayList();
            BlockedTest blockedTest = new BlockedTest();
            for (int i = 0; i < 10; i++) {
                Thread thread = new Thread(blockedTest::test);
                thread.start();
                Thread.sleep(100);
                System.out.println(thread.getState());
                threads.add(thread);
            }

            while (true) {
                threads.forEach(value -> {
                    System.out.println(value.getState());
                });
            }
        }

        public synchronized void test() {
            try {
                Thread.sleep(5000);
                System.out.println("我运行了..");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
