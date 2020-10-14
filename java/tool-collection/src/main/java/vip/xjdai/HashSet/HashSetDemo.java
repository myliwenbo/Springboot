package vip.xjdai.HashSet;

import org.checkerframework.checker.units.qual.K;
import org.junit.Test;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashSetDemo<K, V> {

    @Test
    public void test1() {
        HashSet<Object> objects = new HashSet<>();
        Object o = new Object();
        System.out.println(o.hashCode());
        System.out.println(Integer.toBinaryString(o.hashCode()));
        System.out.println(o.hashCode() >>> 16);
        System.out.println(Integer.toBinaryString(o.hashCode() >>> 16));
        System.out.println(Integer.valueOf("111000101101", 2).toString());
        objects.add("");

    }

    @Test
    public void hash() {
        Object key = new Object();
        int h;
        //三元运算
        h = key.hashCode();
        System.out.println(h);
        System.out.println(Integer.toBinaryString(h));
        //1000111000011100010000000110000  转换成2进制后
        //0000000000000000100011100001110  位移16位后，也就是说从开头开始加16个0，多余的0删掉
        //1234567890123456                 100011100001110
        System.out.println(h >>> 16);
        System.out.println(Integer.valueOf("100011100001110", 2).toString());
        //1000111000011100010000000110000 ^ 0000000000000000100011100001110
        System.out.println((h = key.hashCode()) ^ (h >>> 16));
        //1000111000011100110011100111110
        System.out.println(Integer.valueOf("1000111000011100110011100111110", 2).toString());
    }

    @Test
    public void hashMapTest() throws Exception {
        String key = "";
        int h;
        System.out.println((key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16));

        HashMap<String, String> map = new HashMap<>();
        map.put("张三", null);

    }

    @Test
    public void HashMapTest1() throws Exception {

        HashMap<Object, Object> hashMap = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            hashMap.put(i, i + i);
        }

    }

    @Test
    public void hashCode1() throws Exception {
        String key = "张三";
        int h;
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);

        System.out.println((16 - 1) & hash);
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.toBinaryString(hash));
        //00000000000000001111
        //10111101001011100010
        System.out.println(Integer.valueOf("00000000000000000010", 2).toString());

    }

    @Test
    public void yunsuand() throws Exception {
        int i = 3;
        int o = 5;
        System.out.println(i & o);
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(o));
        //11   前面会补0  011
        //101            101
        //0001           001
        System.out.println(Integer.valueOf("0001", 2).toString());
    }


    @Test
    public void hashCode2() throws Exception {
        String key = "张三";
        int h;
        h = key.hashCode();
        System.out.println(Integer.toBinaryString(h));
        h = h >>> 16;
        System.out.println(Integer.toBinaryString(h));
        //10111101001011101001
        //00000000000000001011
        //10111101001011100010
    }

    @Test
    public void hashCode3() throws Exception {
        int binCount = 7;
        int x = 8;
        int b = 1;
        System.out.println(binCount >= x - b);
    }

}
