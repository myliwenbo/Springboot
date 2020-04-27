package vip.xjdai.demo.thread.parallel;

/**
 * 并行
 */
public class ParallelDemo {

    /**
     * 你吃饭吃到一半，电话来了，你一边打电话一边吃饭，这说明你支持并行。
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        System.out.println("开始吃饭");
        //电脑：1
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("吃了：" + i + "下");
            }
        }).start();
        //电脑：2
        System.out.println("来电话了");
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("通话时长" + i + "秒");
            }
        }).start();
    }
}
