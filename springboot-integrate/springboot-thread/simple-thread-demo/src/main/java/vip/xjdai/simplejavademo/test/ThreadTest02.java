package vip.xjdai.simplejavademo.test;

public class ThreadTest02 {
//    private  lock  String name="";

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            System.out.println("Runnable");
        }).start();
    }
}
