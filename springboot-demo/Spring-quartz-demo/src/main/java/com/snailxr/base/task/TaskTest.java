package com.snailxr.base.task;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class TaskTest {
    public final Logger log = Logger.getLogger(this.getClass());

    public void run() {
        for (int i = 0; i < 1; i++) {
            log.debug(i + " run......................................" + (new Date()));
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
        String c = null;
        Map<String, Charset> charsets = Charset.availableCharsets();
        for (Map.Entry<String, Charset> entry : charsets.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
