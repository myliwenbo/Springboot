package vip.xjdai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import vip.xjdai.ioc.controller.DynamicController;
import vip.xjdai.ioc.service.TestService;
import vip.xjdai.ioc.utils.SpringContextUtil;

@SpringBootTest
class DemoApplicationTests
{

    private TestService testServiceImpl;

    private DynamicController dynamicController;

    /**
     * @throws Exception
     */
    @Test
    public void testName() throws Exception
    {
        //特征信息
        String featureCode = "2";
        testServiceImpl = (TestService) SpringContextUtil.getBean("testServiceImpl" + featureCode);
        testServiceImpl.whoAmI();
    }

    @Test
    public void testDynamic()
    {
        String dynamic = dynamicController.dynamic("");
        System.out.println(dynamic);
    }
}
