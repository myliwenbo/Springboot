package vip.xjdai.jol;

import org.openjdk.jol.info.ClassLayout;

public class JolDemo {
    public static void main(String[] args) throws InterruptedException {
        User value = new User();
        System.out.println(ClassLayout.parseInstance(value).toPrintable());
        //      OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
        //                                                                                  01 代表了无锁态
        //      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
        //      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
        //      8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
        //     12     1   boolean User.flg                                  true   这个对象的熟悉
        //     13     3           (loss due to the next object alignment)     //代表了填充数据
        Thread.sleep(0b111110100000);
        Object value2 = new Object();
        System.out.println(ClassLayout.parseInstance(value2).toPrintable());
        //        OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
        //                                                                                   101 代表了偏向锁--匿名偏向锁，因为没有锁的指针
        //        0     4        (object header)                           05 00 00 00 (00000101 00000000 00000000 00000000) (5)
        //        4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
        synchronized (value) {
            System.out.println(ClassLayout.parseInstance(value).toPrintable());
            //      OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
            //                                                                                  00 代表了轻量级锁
            //      0     4        (object header)                           98 f2 76 02 (10011000 11110010 01110110 00000010) (41349784)
            //      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
            //      8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
        }
        System.out.println(ClassLayout.parseInstance(value).toPrintable());
    }
}
