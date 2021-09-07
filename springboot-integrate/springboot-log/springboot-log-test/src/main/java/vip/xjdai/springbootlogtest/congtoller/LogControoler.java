package vip.xjdai.springbootlogtest.congtoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("LogControoler")
@Slf4j
public class LogControoler {

    @RequestMapping(value = "/log1", method = RequestMethod.POST)
    public void log1() {
        for (int i = 0; i < 10000; i++) {
            log.info("初始化-_-");
            log.error("错误!!!!!");
            log.debug("debug 成了");
            log.warn("警告!!!");
        }
    }

    @RequestMapping(value = "/log2", method = RequestMethod.POST)
    public void log2() {
        for (int i = 0; i < 10000; i++) {
            log.info("初始化-_-");
            log.error("错误!!!!!");
            log.debug("debug 成了");
            log.warn("警告!!!");
        }
    }
}
