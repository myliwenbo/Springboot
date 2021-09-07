package vip.xjdai.springbootbasal.trytest;

import org.junit.jupiter.api.Test;

public class TryTest {
    @Test
    public void test1() throws Exception {
        System.out.println("执行了");
        try {
            System.out.println("try 执行");
        }finally {
            System.out.println("finally 执行");
        }
        System.out.println("结束了");
    }
}
