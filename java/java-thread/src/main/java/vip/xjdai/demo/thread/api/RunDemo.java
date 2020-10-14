package vip.xjdai.demo.thread.api;

public class RunDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("执行了");
        });
        thread.start();
    }
}
