package vip.xjdai.base;

import org.junit.Test;

public class EqualsTest
{
    @Test
    public void equals()
    {
        Integer i  = 321;
        Integer ii = 321;
        System.out.println(i == ii);  // 这里的会进行拆箱操作
        System.out.println(ii.equals(i));
    }

}
