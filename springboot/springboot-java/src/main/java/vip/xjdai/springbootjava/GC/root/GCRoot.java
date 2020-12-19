package vip.xjdai.springbootjava.GC.root;

import org.junit.jupiter.api.Test;

public class GCRoot {

    @Test
    public void clearObject() throws Exception {
        GCRoot gcRoot = new GCRoot();
        System.out.println(gcRoot);
        gcRoot = new GCRoot();
        System.out.println(gcRoot);
    }
}
