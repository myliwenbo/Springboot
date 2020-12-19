package vip.xjdai.springbootthreadjava.thread.demo;

public class ThreadModel {

    static int i = 0;

    public static void main(String[] args) {

        new Thread((() -> {
            //会把 主内存中的i 复制到当前线程的内存中，等处理完成后才会同步到 主内存中去
            while (true) {
                i++;
            }
        })).start();
    }
}
