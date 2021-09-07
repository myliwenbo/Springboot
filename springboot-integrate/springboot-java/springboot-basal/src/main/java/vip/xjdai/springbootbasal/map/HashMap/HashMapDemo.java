package vip.xjdai.springbootbasal.map.HashMap;


import org.checkerframework.checker.units.qual.K;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class HashMapDemo {

    HashMap<String, String> map = new HashMap<>();

    @Test
    public void addNull() throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        map.put(null, "xx");
        System.out.println(map.get(null));
    }

    @Test
    public void hash冲突() throws Exception {
        HashMap<String, Integer> map = new HashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    //准备完毕……运动员都阻塞在这，等待号令
                    countDownLatch.await();
                    String parter = "【" + Thread.currentThread().getName() + "】";
                    System.out.println(parter + "开始执行……");
                    map.put("file:///Z:/JDK8/jre/lib/ext/cldrdata.jar", 1);
                    map.put("file:///Z:/JDK8/jre/lib/ext/jaccess.jar", 1);
                    map.put("file:///Z:/JDK8/jre/lib/ext/dnsns.jar", 1);
                    map.put("file:///Z:/JDK8/jre/lib/ext/access-bridge-64.jar", 1);
                    map.put("file:///Z:/JDK8/jre/lib/ext/jfxrt.jar", 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(2000);// 裁判准备发令
        countDownLatch.countDown();// 发令枪：执行发令
        Thread.sleep(2000);// 主线程暂停
        System.out.println(map);
    }

    @Test
    public void hashMapAddFor() throws Exception {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            map.put(UUID.randomUUID().toString(), i);
        }
    }


    @Test
    public void 取余() throws Exception {
        System.out.println(-123 % 16);

    }


    @Test
    public void 扩容() throws Exception {
        for (int i = 0; i < 500; i++) {
            map.put(i + "", i + "");
        }

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>(1000);
        objectObjectHashMap.put("", "x");
    }

    @Test
    public void weiYi() throws Exception {
        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(16 << 1));
        System.out.println(Integer.valueOf("100000", 2).toString());
    }


    @Test
    public void hashCodeT() throws Exception {
        System.out.println("10000".hashCode());
        System.out.println("10000".hashCode() >>> 16);
        System.out.println("10000".hashCode() ^ "10000".hashCode() >>> 16);
        System.out.println(46729592 & 15);

    }

    @Test
    public void youyi() throws Exception {
        System.out.println("123123".hashCode());
        System.out.println(Integer.toBinaryString("123123".hashCode()));
        System.out.println(Integer.toBinaryString("123123".hashCode() >>> 16));
        System.out.println();
    }

    @Test
    public void 异或运算() throws Exception {
        System.out.println(Integer.toBinaryString("123123".hashCode() ^ "123123".hashCode() >>> 16));
        System.out.println(Integer.valueOf("0000000000000000000000000000101", 2).toString());

    }

    @Test
    public void 十进制() throws Exception {
        System.out.println(Integer.valueOf("111", 2).toString());
    }

    @Test
    public void 二进制() throws Exception {
        System.out.println(Integer.toBinaryString(31));
        System.out.println(Integer.toBinaryString(15));
    }

    @Test
    public void hashCodeTest() throws Exception {
        //14 5057 2480
        System.out.println("123123".hashCode());
        System.out.println(Integer.toBinaryString("123123".hashCode()));
    }


    @Test
    public void ci_fang_2() throws Exception {
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(32));
        System.out.println(Integer.toBinaryString(64));
    }

    @Test
    public void index_count() throws Exception {
        for (int i = 0; i < 50; i++) {
             System.out.println((("Hello Map：" + i).hashCode() ^ ("Hello Map：" + i).hashCode() >>> 16)& 8-1);
//            System.out.println(Integer.toBinaryString((("Hello Map：" + i).hashCode() ^ ("Hello Map：" + i).hashCode() >>> 16)));
        }
    }

    @Test
    public void tableSizeFor() throws Exception {
        HashMap<String, String> map = new HashMap<>(10);
        int n = 10; //10
        System.out.println(Integer.toBinaryString(n)); //1010
        System.out.println(Integer.toBinaryString(n >>> 1));//0101
        //1010
        //0101
        //1111
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n)); //1111
        System.out.println(Integer.toBinaryString(n >>> 2));//0011
        //1111
        //0011
        //1111
        n = n | n >>> 2;
        System.out.println(Integer.toBinaryString(n));//1111
        System.out.println(Integer.toBinaryString(n >>> 4));//0000
        //1111
        //0000
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));//1111
        System.out.println(Integer.toBinaryString(n >>> 8));//0000 0000
        //0000 1111
        //0000 0000
        //0000 1111
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));// 1111
        System.out.println(Integer.toBinaryString(n >>> 16));//0000 0000 0000 0000
        //0000 0000 0000 1111
        //0000 0000 0000 0000
        //0000 0000 0000 1111
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));//1111
        //1111
        System.out.println((n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1);
        //8+4+2+1+1=16
        System.out.println("N 小于0 取1");
        System.out.println("N >=1<<30 取1<<30");
        System.out.println("n+1");
    }
    // if ((p = tab[i = (n - 1) & hash])

    @Test
    public void test30() throws Exception {
        System.out.println(1<<30);
        //1073741824
        System.out.println(Integer.MAX_VALUE);
    }

}
