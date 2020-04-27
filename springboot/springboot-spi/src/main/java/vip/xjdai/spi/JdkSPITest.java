package vip.xjdai.spi;

import org.junit.Test;

import java.util.ServiceLoader;

public class JdkSPITest {

    @Test
    public void testSayHi() throws Exception {
        //获取实现类
        ServiceLoader<Developer> serviceLoader = ServiceLoader.load(Developer.class);
        serviceLoader.forEach(Developer::sayHi);
    }
}