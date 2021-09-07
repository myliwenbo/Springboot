package vip.xjdai.simplevolatiledemo;

public class VolatileExample1 {
    private static String name = "init";

    private static boolean flag = false;

    public static void main(String[] args) {
        new Thread(() -> {
            name = "yukong";
            flag = true;
        });
        new Thread(() -> {
            if (flag) {
                System.out.println("name：" + name);
                System.out.println("flag：" + flag);
            }
        });
    }


}
