package vip.xjdai.springbootbasal.date;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;

public class DateTest1 {

    @Test
    public void test1() throws Exception {
        System.out.println(System.currentTimeMillis() / (1000 * 60 * 60 * 24)
        );
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(sdf.format(d));
        System.out.println(System.currentTimeMillis() >>> 4);
        System.out.println(System.currentTimeMillis() >>> 3);
    }
}
