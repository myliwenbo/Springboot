package vip.xjdai.HashSet;

import org.checkerframework.checker.units.qual.K;
import org.junit.Test;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashSetDemo<K,V> {

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
        int i = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        // h>>>16，右移16位，前面补0
        //1110001011010101011010111111
        //0000000000000000111000101101
        //1110001011010101011010111111 ^ 0000000000000000111000101101
        //0000000000000000111000101101
        //1110001011010101100010010010
    }


}
