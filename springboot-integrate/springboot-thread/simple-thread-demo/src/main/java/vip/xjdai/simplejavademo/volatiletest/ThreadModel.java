package vip.xjdai.simplejavademo.volatiletest;

public class ThreadModel {

    static int x = 0;

    public static void main(String[] args) {
        new Thread((() -> {
            //会把 主内存中的x 复制到当前线程的内存中，等处理完成后才会同步到 主内存中去
            while (true) {
                System.out.println(Thread.currentThread().getName() + "一直在添加X的值");
                if (x >= 1000) {
                    return;
                }
                try {
                    x++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }), "线程-1").start();
        new Thread((() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " 一直读取X的值：" + x);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }), "线程-2").start();
    }
}