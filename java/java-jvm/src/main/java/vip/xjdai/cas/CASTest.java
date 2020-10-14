package vip.xjdai.cas;

import org.junit.Test;

/**
 * CAS 模拟
 */
public class CASTest {
    /**
     * 内存中的值
     */
    private static int i = 0;

    public static void main(String[] args) {
        new Thread(CASTest::cas).start();
        new Thread(CASTest::cas).start();
        new Thread(CASTest::cas).start();
        new Thread(CASTest::cas).start();
        new Thread(CASTest::cas).start();
        new Thread(CASTest::cas).start();
        new Thread(CASTest::count).start();
    }

    private static void count() {
        i++;
    }

    private static void cas() {
        int copy = i;
        //判断值是否相对，如果相等，等于此次的值没被改变
        if (copy == i) {
            i += 1;//进行计算
            System.out.println(i);
            return;
        }
        System.out.println("我执行了几次");
        cas();//不相等，就代表了内存中的值被改变了
    }

}

