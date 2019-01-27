package cn.lwb.log;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 使用注解的方式，当然需要 lombok
 * @author lwb
 *
 */
@Slf4j
@RestController
@RequestMapping("/logTwo")
public class TestControllerTwo {

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
