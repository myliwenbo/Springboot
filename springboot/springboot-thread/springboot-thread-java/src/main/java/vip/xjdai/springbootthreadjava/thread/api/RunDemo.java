package vip.xjdai.springbootthreadjava.thread.api;

public class RunDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("执行了");
        });
        thread.start();
    }
}
