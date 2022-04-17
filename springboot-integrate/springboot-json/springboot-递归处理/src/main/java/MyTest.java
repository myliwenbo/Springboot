import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.format.DateParser;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import pro.shushi.pamirs.meta.common.exception.PamirsException;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@Component
public class MyTest {

    public static void main(String[] args) throws Exception {
//        ClassLoader loader = FileUtil.class.getClassLoader();
//        //   读取的文件名称
//        InputStream stream = loader.getResourceAsStream("ceshi.json");
//        String text = IOUtils.toString(stream, StandardCharsets.UTF_8);
//        List<CodeInfoNotifyBody> qtsCodeChainTreeEipModels = JSON.parseArray(text, CodeInfoNotifyBody.class);
//        for (CodeInfoNotifyBody qtsCodeChainTreeEipModel : qtsCodeChainTreeEipModels) {
//            System.out.println(qtsCodeChainTreeEipModel.getBusinessNo());
//        }
//        System.out.println(formatDateStrByDay(-1));
//        System.out.println(stringToTimestamp("2022-03-23T15:02:07.796492"));

        try {
            set();
        } catch (Exception exception) {
            if (exception instanceof RuntimeException) {
                RuntimeException pamirsException = (RuntimeException) exception;
                System.out.println(pamirsException.getMessage());
            }
        }
    }

    public static Timestamp stringToTimestamp(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        String date = str.replace("T", " ");
        String format = DatePattern.NORM_DATETIME_MS_FORMAT.format((Timestamp.valueOf(date)));
        return Timestamp.valueOf(format);
    }


    public static void set() {
        throw new RuntimeException("测试异常");
    }

    /**
     * 转换 yyyy-MM-dd格式字符串
     *
     * @param day
     * @return
     */
    public static String formatDateStrByDay(Integer day) {

        //获取前一天日期
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, day);
        Date yesterday = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sdfStr = sdf.format(yesterday);
        return sdfStr;
    }

    /**
     * 转换 yyyyMMdd格式字符串
     *
     * @param day
     * @return
     */
    public static String formatDateStrByDay2(Integer day) {
        //获取前一天日期
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, day);
        Date yesterday = c.getTime();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
        String sdfStr = sdf2.format(yesterday);
        return sdfStr;
    }


}