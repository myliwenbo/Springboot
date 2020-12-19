package vip.xjdai.springbootthreadjava.thread.api;

/**
 * 终止或者退出
 */
class ExitThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "攻击了" + "[" + i + "]");
        }
    }

    public static void main(final String[] args) throws Exception {
        final ExitThread exitThread = new ExitThread();
        exitThread.start();
        exitThread.interrupt();
        System.out.println(exitThread.interrupted());
        System.out.println(exitThread.interrupted());
    }

}

class ExitThread3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if (this.interrupted()) {
                System.out.println("线程已经终止我要退出了");
                break;
            }
            System.out.println(Thread.currentThread().getName() + "攻击了" + "[" + i + "]");
        }
    }

    public static void main(final String[] args) throws Exception {
        final ExitThread3 exitThread3 = new ExitThread3();
        exitThread3.start();
        Thread.sleep(1000);
        exitThread3.interrupt();  //告知当前线程
        System.out.println("end");

    }

}

class ExitThread2 extends Thread {

    public static void main(final String[] args) {
        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
        System.out.println("end");

    }

}

class ExitThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "攻击了" + "[" + i + "]");
        }
    }

    public static void main(final String[] args) {
        final ExitThread exitThread = new ExitThread();
        exitThread.start();
        exitThread.stop();

    }

}
