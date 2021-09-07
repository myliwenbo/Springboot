/**
 * 
 */
package vip.xjdai.log;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

    @Test
    public void test() {
        log.info("我是初始化");
        log.debug("我是dbug");
        log.warn("我是警告");
        log.error("我是严重的错误");
    }
}
