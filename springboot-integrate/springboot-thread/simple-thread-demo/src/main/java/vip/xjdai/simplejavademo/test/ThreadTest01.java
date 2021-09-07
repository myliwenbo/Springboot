package vip.xjdai.simplejavademo.test;


public class ThreadTest01 {
//    private  lock  String name="";

    public static void main(String[] args) throws Exception {
        //一个窗口，100个人同时买咖啡
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> System.out.println("买咖啡顺序：" + finalI)).start();
        }
    }
}
