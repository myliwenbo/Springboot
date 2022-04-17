package vip.xjdai;

import cn.hutool.core.date.format.FastDateFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class XmlToJavaApplication {

    public static void main(String[] args) {
        FastDateFormat simpleDateFormat = FastDateFormat.getInstance("yyyyMMdd HHmmss");
        String format = simpleDateFormat.format("2021");
        System.out.println(format);
    }
}
