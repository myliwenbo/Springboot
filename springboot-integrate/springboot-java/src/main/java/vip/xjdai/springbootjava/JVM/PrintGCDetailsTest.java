package vip.xjdai.springbootjava.JVM;

public class PrintGCDetailsTest {
    private byte[] bytes;

    public static class PrintGCDetails {

        public static void main(String[] args) {
            for (int i = 0; i < 500; i++) {
                PrintGCDetailsTest printGCDetailsTest = new PrintGCDetailsTest();
                printGCDetailsTest.bytes = new byte[i];
            }
        }
    }
}
