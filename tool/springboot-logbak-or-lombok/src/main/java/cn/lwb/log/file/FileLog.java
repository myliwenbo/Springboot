package cn.lwb.log.file;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/fileLog")
public class FileLog {

    @RequestMapping(value = "/logTwo", method = RequestMethod.POST)
    public void countOrder() {
        for (int i = 0; i < 10000; i++) {
            log.info("初始化-_-");
            log.debug("debug 成了");
            log.warn("警告!!!----测试");
            log.error("错误!!!!!");
        }
    }
}
