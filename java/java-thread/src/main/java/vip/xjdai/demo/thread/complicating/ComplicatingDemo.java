package vip.xjdai.demo.thread.complicating;

public class ComplicatingDemo {

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

class ComplicatingDemo1 {
    static boolean status = true;

    static  int i = 1;


    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            while (status) {
                i++;
            }
            System.out.println(i);
            System.out.println("退出循环");
        }).start();
        Thread.sleep(1000);
        new Thread(() -> status = false).start();

    }
}
