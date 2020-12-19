package vip.xjdai.springbootthreadjava.thread.demo;

/**
 * 并行演示
 */
public class ThreadDemo {
    /**
     * 并行演示
     *
     * @param args
     */
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("跟甲聊天：" + i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("跟已聊天：" + i);
            }
        }).start();
    }

}
