package vip.xjdai.spi;

import org.junit.Test;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

public class JdkSPITest {

    @Test
    public void testSayHi() throws Exception {
        //获取实现类
        ServiceLoader<Developer> serviceLoader = ServiceLoader.load(Developer.class);

        serviceLoader.forEach(Developer::sayHi);
    }

    @Test
    public void getAllIPeopleImpl() throws IllegalAccessException, InstantiationException {
        Reflections reflection = new Reflections("vip.xjdai");
        Map<String, Class> map = new HashMap<>();
        Set<Class<? extends Developer>> set = reflection.getSubTypesOf(Developer.class);
        for (Class c : set) {
            Developer o = (Developer) c.newInstance();
            o.sayHi();
        }
    }
}
