package vip.xjdai.springbootbasal.compute;

import org.junit.jupiter.api.Test;

public class 按位与 {

    @Test
    public void test1() throws Exception {
        int i = 0;
        if (1 != 1 & 1 == (i = 1 + 2)) {
        }
        System.out.println(i);
    }

}
