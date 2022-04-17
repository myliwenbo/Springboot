package vip.xjdai.springboottimestamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;

@SpringBootApplication
public class SpringbootTimestampApplication {

    public static void main(String[] args) {
        Timestamp externalTime = Timestamp.valueOf("2018-05-19 09:32:32");
        Timestamp dateTime = Timestamp.valueOf("2018-05-19 09:32:32");
        boolean oldData = isOldData(externalTime, dateTime);
        System.out.println(oldData);
    }


    /**
     * @param externalTime 外部时间
     * @param dateTime     数据库时间
     * @return false ：数据库时间比较新
     */
    public static boolean isOldData(Timestamp externalTime, Timestamp dateTime) {
        if (externalTime != null && externalTime.before(dateTime)) {
            System.out.println("数据库时间比较新");
            return false;
        } else {
            System.out.println("外部时间比较新，并且不一致，因为存在一致的情况");
            return !externalTime.equals(dateTime);
        }
    }
}
