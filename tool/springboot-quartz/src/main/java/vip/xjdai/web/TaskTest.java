package vip.xjdai.web;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TaskTest {

    public void run() {
        for (int i = 0; i < 1; i++) {
            log.debug(" run......................................" + (new Date()));
        }

    }

    public void run1() {
        for (int i = 0; i < 1; i++) {
            log.debug(
                i + " run1............http://localhost:8080/quartz-spring_demo/task/taskList.htm.........................."
                      + (new Date()));
        }
    }

    public static void main(String[] args) {
        Map<String, Charset> charsets = Charset.availableCharsets();
        for (Map.Entry<String, Charset> entry : charsets.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
