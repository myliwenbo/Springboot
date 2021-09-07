package vip.xjdai.springbootjava.JVM;

public class JVMTest {

    public static void main(String[] args) {
        // 现在内存的最大值
        long maxMemory = Runtime.getRuntime().maxMemory();
        // 未使用内存
        long freeMemory = Runtime.getRuntime().freeMemory();
        // 总内存
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println(maxMemory);
        System.out.println(freeMemory);
        System.out.println(totalMemory);

        byte[] bytes = new byte[1024 * 1024];
        // 现在内存的最大值
        System.out.println(maxMemory - Runtime.getRuntime().maxMemory());
        System.out.println(freeMemory - Runtime.getRuntime().freeMemory());
        System.out.println(totalMemory - Runtime.getRuntime().totalMemory());
        //1048576
        //1048592

    }
}
