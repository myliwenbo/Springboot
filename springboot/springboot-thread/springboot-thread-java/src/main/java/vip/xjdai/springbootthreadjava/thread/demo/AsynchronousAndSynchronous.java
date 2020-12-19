package vip.xjdai.springbootthreadjava.thread.demo;

/**
 * 异步，两个线程， 主线程和新开辟的线程
 */
public class AsynchronousAndSynchronous {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                //休眠1秒
                Thread.sleep(1000)
                ;                //不一定先去处理A方法
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            A();
        });
        t.start();
        B();
    }

    public static void A() {
        System.out.println("A方法");
    }

    public static void B() {
        System.out.println("B方法");
    }

    /**
     * 同步执行.就一个主线程，执行到结束
     */
    static class SynchronizeDemo {

        public static void main(String[] args) {
            A();
            B();
        }

        public static void A() {
            System.out.println("A方法执行了");
        }

        public static void B() {
            System.out.println("B方法执行了");
        }

    }


}

