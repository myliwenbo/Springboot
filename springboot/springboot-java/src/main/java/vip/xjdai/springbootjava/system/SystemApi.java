package vip.xjdai.springbootjava.system;

import org.junit.jupiter.api.Test;

public class SystemApi {

    @Test
    public void nanoTime() throws Exception {
        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
    }
}
