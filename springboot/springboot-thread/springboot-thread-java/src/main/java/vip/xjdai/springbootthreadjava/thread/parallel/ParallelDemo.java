package vip.xjdai.springbootthreadjava.thread.parallel;

/**
 * 并行
 */
public class ParallelDemo {

    /**
     * 两个窗口
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //窗口：1
        new Thread(() -> {
            System.out.println("窗口-1：");
            for (int i = 0; i < 100; i++) {
                System.out.println("卖了一杯咖啡");
            }
        }).start();
        //窗口：2
        System.out.println("窗口-2：");
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("卖了一杯咖啡");
            }
        }).start();
    }
}
