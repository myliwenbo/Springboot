package vip.xjdai.HashSet;

import org.junit.Test;

import java.util.HashMap;

public class HashMapDemo {


    @Test
    public void HashMap() throws Exception {

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 68; i++) {
            map.put(i + "", i + "");
        }
    }

    @Test
    public void weiYi() throws Exception {
        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(16 << 1));
        System.out.println(Integer.valueOf("100000", 2).toString());

    }

}
