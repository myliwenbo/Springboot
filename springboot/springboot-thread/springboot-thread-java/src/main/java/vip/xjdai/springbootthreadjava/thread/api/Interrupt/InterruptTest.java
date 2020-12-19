package vip.xjdai.springbootthreadjava.thread.api.Interrupt;

import lombok.SneakyThrows;
import org.junit.platform.commons.function.Try;

public class InterruptTest {

    public static class Interrupt {

        public static void main(String[] args) {
            Thread thread = new Thread(() -> {
                int num = 0;
                while (num <= Integer.MAX_VALUE / 2) {
                    if (num % 10000 == 0) {
                        System.out.println(num + "：是10000的倍数");
                    }
                    num++;
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().isInterrupted());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

    public static class InterruptTestOne {
        @SneakyThrows
        public static void main(String[] args) {
            Thread thread = new Thread(() -> {
                int num = 0;
                while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
                    if (num % 10000 == 0) {
                        System.out.println(num + "：是10000的倍数");
                    }
                    num++;
                }
            });
            thread.start();
            Thread.sleep(100);
            //349810000
            //33350000
            thread.interrupt(); //1073740000
        }
    }

    public static class InterruptTestTwo {

        public static void main(String[] args) throws InterruptedException {
            Thread thread = new Thread(() -> {
                try {
                    int num = 0;
                    while (num <= Integer.MAX_VALUE / 2) {
                        if (num % 10 == 0) {
                            System.out.println(num + "：是10000的倍数");
                        }
                        num++;
                        Thread.sleep(10); // 触发中断
                    }
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
            });
            thread.start();
            Thread.sleep(5000);
            //349810000
            //33350000
            thread.interrupt(); //1073740000
        }
    }


    public static class InterruptTestThree {

        public static void main(String[] args) throws InterruptedException {
            Thread thread = new Thread(() -> {
                int num = 0;
                while (!Thread.currentThread().isInterrupted()||num <= Integer.MAX_VALUE / 2 ) {
                    if (num % 10 == 0) {
                        System.out.println(num + "：是10的倍数");
                    }
                    num++;
                    try {
                        Thread.sleep(100); // 触发中断
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
            thread.start();
            Thread.sleep(5000);
            //349810000
            //33350000
            thread.interrupt(); //1073740000
        }
    }

}
