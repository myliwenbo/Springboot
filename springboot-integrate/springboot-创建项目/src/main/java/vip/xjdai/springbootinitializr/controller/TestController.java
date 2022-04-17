package vip.xjdai.springbootinitializr.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
public class TestController {


    @RequestMapping("test")
    public void test() {


    }

    public static void main(String[] args) {
        System.out.println(TestController.stringToTimestamp(LocalDateTime.now().toString()));
//        Timestamp timestamp =

    }

    public static Timestamp stringToTimestamp(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        String date = str.replace("T", " ");
        return Timestamp.valueOf(date);
    }
}
