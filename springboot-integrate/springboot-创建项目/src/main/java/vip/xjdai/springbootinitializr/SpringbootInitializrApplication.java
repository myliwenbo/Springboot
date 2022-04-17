package vip.xjdai.springbootinitializr;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.unit.DataUnit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

@EnableCaching
@SpringBootApplication
public class SpringbootInitializrApplication {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDate nowDate = now.toLocalDate();
        System.out.println(DateUtil.date(LocalDateTime
                .of(nowDate, LocalTime.of(2, 30))
                .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()));
    }
}
