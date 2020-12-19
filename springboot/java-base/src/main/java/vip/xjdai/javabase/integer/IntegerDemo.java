package vip.xjdai.javabase.integer;

import org.junit.Test;

public class IntegerDemo {

    @Test
    public void eq() throws Exception {
        int i1 = 300;
        int i2 = 300;
        System.out.println(i1 == i2); // 比对基本具体的值
    }

    @Test
    public void eq1() throws Exception {
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);
        // true 需要注意 此时的 i1 和i2 是同一个对象
        // 因为 Integer.IntegerCache 初始化的时候将 -128 和 127 进行创建
    }

    @Test
    public void eq2() throws Exception {
        Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1 == i2);
        // false 需要注意 此时的 i1 和i2 不是同一个对象
        // 因为 Integer.IntegerCache 初始化的时候"只"将 -128 和 127 进行创建，并没有缓存其他值
        // 下面是编译后的结果
        // Integer i1 = Integer.valueOf(128);
        // Integer i2 = Integer.valueOf(128);
        // 下面是源码
        // public static Integer valueOf(int i) {
        //      当I >= 缓存中的值 并且 1<= 长度 则返回 缓存中的值
        //     if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high)
        //         return Integer.IntegerCache.cache[i + (-Integer.IntegerCache.low)];
        //      否则进行创建..
        //     return new Integer(i);
        // }
    }
}
