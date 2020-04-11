package cn.lwb.integer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import org.junit.jupiter.api.Test;

@SuppressWarnings({"unused", "resource", "unlikely-arg-type"})
public class Main_1 {

    public static void main(String[] args) {
        Integer e = 321;
        Integer f = 321;
        Integer c = 3;
        Integer d = 3;
        Integer a = 1;
        Integer b = 2;
        Long g = 3L;
        Long h = 2L;
        System.out.println(c == d);//true 为什么 ? 因为使用==是比较的地址值，而Integer维护了 -128-127的地址，所以只要在这中间都会维护地址值
        System.out.println(e == f);//false为什么 ? 因为已经超出了Integer缓存的数据，超出后会创建两个对象 ，对象的地址值不一样，所以false
        System.out.println(c == (a + b));//true 为什么 ? 因为在Integer缓存中
        System.out.println(c.equals(a + b));//true 为什么?  本来就是比对的具体的值
        System.out.println(g == (a + b));//true 为什么?   因为是设计成这样的
        System.out.println(g.equals(a + b));//false 为什么?因为 A+B 会先转成Integer 那等于是 Long==Integer，所以是false 
        System.out.println(g.equals(a + h));//true 为什么??因为 A+H 会先转成 Long 那就等于是 Long.value==Long.value ，所以是true

    }

    @Test
    public void testxx() throws FileNotFoundException {
        File file = new File("application.properties");

        FileInputStream ip = new FileInputStream(file);
        System.out.println(file.isFile());
    }
}
