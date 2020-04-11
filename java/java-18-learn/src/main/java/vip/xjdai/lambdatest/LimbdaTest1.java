package vip.xjdai.lambdatest;

import org.junit.Test;

public class LimbdaTest1 {

    @Test
    public void test1() throws Exception {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

    }

    @Test
    public void test2() throws Exception {

        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

    }
}
