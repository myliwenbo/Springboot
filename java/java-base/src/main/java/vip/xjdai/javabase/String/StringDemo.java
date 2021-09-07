package vip.xjdai.javabase.String;

import org.junit.Test;

public class StringDemo {

    @Test
    public void eq1() throws Exception {
        String s1 = new String("A");
        String s2 = new String("A");
        System.out.println(s1 == s2);
        // false 因为比较的是 S1 和 S2的地址值
    }

    @Test
    public void eq2() throws Exception {
        String s1 = "A";
        String s2 = "A";
        System.out.println(s1 == s2);
        // true 因为 s1 和s2 比的具体的值..
    }

    // 常量A
    public static final String A = "ab";
    // 常量B
    public static final String B = "cd";

    @Test
    public void seq() throws Exception {
        // 将两个常量用+连接对s进行初始化
        String s = A + B;
        String t = "abcd";
        // A和B都是常量，值是固定的，因此s的值也是固定的，它在类被编译时就已经确定了。
        if (s == t) {
            System.out.println("");
        }
        // 编译后
        // String s = "abcd";
        // 也就是说 在编译的时候会将 A+B 转换成 abcd
    }
    @Test
    public void eq3() throws Exception {
        String a = "ab";// 创建了一个对象，并加入字符串池中
        String b = "cd";// 创建了一个对象，并加入字符串池中
        String c = "cd"+"ab";// 创建了一个对象，并加入字符串池中
        System.out.println(b==(c+a));
    }

}
