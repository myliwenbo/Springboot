package vip.xjdai.annotation.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vip.xjdai.SpringbootLogbakApplication;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringbootLogbakApplication.class })
public class Demo
{
    @Test
    public void test()
    {
        for (int i = 0; i < 1000; i++) {
            log.info("我是初始化");
            log.debug("我是dbug");
            log.warn("我是警告");
            log.error("我是严重的错误");
        }
    }

    @Test
    public void test1()
    {
        System.out.println("vip.xjdai.annotation.test".length());
    }

}
