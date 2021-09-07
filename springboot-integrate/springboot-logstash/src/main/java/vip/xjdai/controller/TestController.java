/**
 * 
 */
package vip.xjdai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lwb
 *
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @RequestMapping("test")
    public void test() {
        log.info("我是初始化");
        log.debug("我是dbug");
        log.warn("我是警告");
        log.error("我是严重的错误");
    }
}
