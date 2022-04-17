package vip.xjdai.springbootrecursion;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@SpringBootTest
class SpringbootRecursionApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(DateUtil.formatDate(DateUtil.yesterday()));
    }

}
