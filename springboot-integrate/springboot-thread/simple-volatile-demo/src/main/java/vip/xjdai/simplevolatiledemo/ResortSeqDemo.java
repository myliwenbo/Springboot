package vip.xjdai.simplevolatiledemo;

public class ResortSeqDemo {
    int a = 0;
    boolean flag = false;

    public void method01() {
        a = 1;
        flag = true;
    }

    public void method02() {
        if (flag) {
            a = a + 5;
            System.out.println("reValue:" + a);
        }
    }

    public static void main(String[] args) {
        ResortSeqDemo value = new ResortSeqDemo();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                value.method01();
                value.method02();
            }).start();
            new Thread(() -> {
                value.method01();
                value.method02();
            }).start();
        }
    }
}