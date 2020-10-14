package vip.xjdai;

import com.github.odiszapc.nginxparser.NgxConfig;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

//参考：https://www.cnblogs.com/zhangdanyang95/p/11322159.html
@SpringBootApplication
public class NginxParsingApplication {

    public static void main(String[] args) {
        SpringApplication.run(NginxParsingApplication.class, args);
    }

    @Test
    public void ngxin() throws Exception {
        NgxConfig conf=NgxConfig.read("");


    }
}
