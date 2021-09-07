package vip.xjdai.simplevolatiledemo;


public class ThreadTest {
    private static String name = "init";
    private static boolean tag = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            name = "yao";
            tag = true;
        });
        Thread thread2 = new Thread(() -> {
            if (tag) {
                System.out.println("name=" + name + "    tag=" + tag);
            }
        });
        thread1.start();
        thread2.start();
    }
}