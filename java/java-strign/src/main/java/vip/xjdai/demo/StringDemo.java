package vip.xjdai.demo;

import org.junit.Test;

public class StringDemo {

    public static void main(String[] args) {
        String s = new String("string");
    }

    public static class Buffer {
        public static void main(String[] args) {
            StringBuffer stringBuffer = new StringBuffer("法外狂赌");
            for (int i = 0; i < 20; i++) {
                int finalI = i;
                new Thread(() -> {
                    //追加
                    stringBuffer.append(finalI).append("-");
                }).start();
            }
            System.out.println(stringBuffer.toString());
        }
    }


    public static class Builder {

        public static void main(String[] args) {
            StringBuilder stringBuilder = new StringBuilder("张三");
            for (int i = 0; i < 20; i++) {
                int finalI = i;
                new Thread(() -> {
                    //追加
                    stringBuilder.append(finalI).append("-");
                }).start();
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
