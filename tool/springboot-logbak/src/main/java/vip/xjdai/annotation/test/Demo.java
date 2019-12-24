package vip.xjdai.annotation.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vip.xjdai.SpringbootLogbakApplication;
import vip.xjdai.annotation.test.error.ErrorDemo;
import vip.xjdai.annotation.test.info.InfoDemo;
import vip.xjdai.annotation.test.warn.WarnDemo;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringbootLogbakApplication.class })
public class Demo
{
    @Test
    public void test()
    {
        for (int i = 0; i < 1000; i++) {
            ErrorDemo.errorLog();
            InfoDemo.info();
            WarnDemo.warn();
        }
    }

    @Test
    public void test1()
    {
        System.out.println("vip.xjdai.annotation.test".length());
    }

}
