package vip.xjdai.springbootthreadjava.thread.parallel;

public class ComplicatingTest {

    public static void main(String[] args) throws Exception {
        //一个窗口，100个人同时买咖啡
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(1000L);
                    System.out.println("买咖啡顺序：" + finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

