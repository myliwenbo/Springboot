package cn.lwb.annotation.dynamic.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lwb.annotation.dynamic.service.TestService;
import cn.lwb.utils.SpringContextUtil;

/**
 * 动态获取service
 * 思路，在AOP获取特征信息，然后通过AOP进行依赖注入实现动态化注入对象
 * @author lwb
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDemo {

    private TestService testServiceImpl;

    /**
     * @throws Exception
     */
    @Test
    public void testName() throws Exception {
        String featureCode = "2";
        testServiceImpl = (TestService) SpringContextUtil
            .getBean("testServiceImpl" + featureCode);
        testServiceImpl.whoAmI();

    }
}
