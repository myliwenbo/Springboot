package vip.xjdai.datedemo;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;

/**
 * 参考 ：https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247487101&idx=1&sn=b4b3d5b64f745359eab23c0dcdc1a627&chksm=fba6e67eccd16f68dd8691165e815d13d4bdaa77727f87c13241adced6e03c88dff4d79c7e24&scene=0&xtrack=1&key=ac4e4e9bf4769bb4147419d22f6bae7aa85660e4359b104ad09dfea19c6656128fcee9ee7a16453ecf2ef9dac3abb791a51b795d5ba19acf3e56e960a0692045a0fa63b58772a64ff80a582ceb76f75c&ascene=14&uin=NDY3NzUxNTYw&devicetype=Windows+10&version=62080079&lang=zh_CN&exportkey=AXTullfUn%2ByHW0qEXw2KJik%3D&pass_ticket=VmGd74uDy9rZj%2BH4H8BjG2yycQhaPzbWkFPcAAx3fBt24fVM5WxUqVb0k0t0iQzR
 */
public class DateDemoTest {
    
    @Test
    public void now() throws Exception {
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期:"+today);
    }

    @Test
    public void getDay() throws Exception {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.println("年:"+year);
        System.out.println("月:"+month);
        System.out.println("日:"+day);
    }

    @Test
    public void customizeDate() throws Exception {
        LocalDate date = LocalDate.of(2018,2,6);
        System.out.println("自定义日期:"+date);

    }

    @Test
    public void equalsDate() throws Exception {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2018,2,5);
        if(date1.equals(date2)){
            System.out.println("时间相等");
        }else{
            System.out.println("时间不等");
        }

    }
    @Test
    public void  checkDate() throws Exception {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2018,2,6);
        MonthDay birthday = MonthDay.of(date2.getMonth(),date2.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(date1);
        if(currentMonthDay.equals(birthday)){
            System.out.println("是你的生日");
        }else{
            System.out.println("你的生日还没有到");
        }

    }

    @Test
    public void getTime() throws Exception {
        LocalTime time = LocalTime.now();
        System.out.println("获取当前的时间,不含有日期:"+time);
    }

    @Test
    public void isLeapYear() throws Exception {
        LocalDate today = LocalDate.now();
        if(today.isLeapYear()){
            System.out.println("今年是润年");
        }else {
            System.out.println("今年不少闰年");
        }

    }
}
