package vip.xjdai.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/consoleLog")
public class ConsoleLog {

    @RequestMapping(value = "/logTwo", method = RequestMethod.POST)
    public void countOrder() {
        for (int i = 0; i < 10000; i++) {
            log.info("初始化-_-");
            log.error("错误!!!!!");
            log.debug("debug 成了");
            log.warn("警告!!!");
        }
    }
}
