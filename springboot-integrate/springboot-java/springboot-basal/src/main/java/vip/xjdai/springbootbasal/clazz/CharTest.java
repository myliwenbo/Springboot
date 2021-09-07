package vip.xjdai.springbootbasal.clazz;

import org.junit.jupiter.api.Test;

public class CharTest {
    public static void main(String[] args) {
        char name = '你';
        System.out.println(name);
        name += '好';
        // 会乱码，为什么？
        // 因为 char 只能存放两个字节内容
        System.out.println(name);
//        System.out.println("你好".value.length);
    }

    @Test
    public void test1() throws Exception {
        Object o = new Object();
        Object o1 = new Object();
        System.out.println(0 == 01);

    }
}
