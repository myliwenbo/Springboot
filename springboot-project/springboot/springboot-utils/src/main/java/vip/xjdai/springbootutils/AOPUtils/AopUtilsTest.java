package vip.xjdai.springbootutils.AOPUtils;


import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vip.xjdai.springbootutils.AOPUtils.config.AopConfig;
import vip.xjdai.springbootutils.AOPUtils.model.IEmployeeService;
import vip.xjdai.springbootutils.AOPUtils.model.MyService;

//参考：https://www.cnblogs.com/jixp/articles/9310358.html
@SpringBootTest(classes = AopConfig.class)
public class AopUtilsTest {

    @Autowired
    private IEmployeeService service;

    @Autowired
    private MyService myService;

    @Test
    public void testIsAop() {
        // 判断是不是代理对象
        System.out.println(AopUtils.isAopProxy(service));
        // 1. 判断是否是SpringProxy类型，Spring中的所有的代理对象，都会实现这个接口，这个接口是一个标记接口：
        // 2. 使用JDK的Proxy的isProxyClass方法，判定该对象是否是JDK的代理实现，即是否是基于接口代理；
        // 3. 使用ClassUtils的isCglibProxyClass方法判断该对象是否是cglib代理实现；
        // 5. 为什么要这样判断?因为Spring需要判定这个对象是否是由spring完成的AOP代理；
        //------------------------------------------------------------------------
        //判断是不是 JDKProxy
        System.out.println(AopUtils.isJdkDynamicProxy(service));

        //判断是不是Cglib代理，没有接口实现的则是 采用Cglib 进行处理
        System.out.println(AopUtils.isCglibProxy(myService));
    }

    /**
     * 获取目标Class
     */
    @Test
    public void getTargetClass() {
        System.out.println(myService.getClass());
        System.out.println(AopUtils.getTargetClass(myService));
    }

    @Test
    public void canApply() throws Exception {
        // 判断一个切入点能否匹配一个指定的类型；
        AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
        pc.setExpression("execution(* vip.xjdai.springbootutils.AOPUtils.model.*Service.*(..))");
        System.out.println(AopUtils.canApply(pc, MyService.class));
        // -------------------------------------------------------------
        // 判断一个切入点能否匹配一个指定的类型，是否支持引入匹配；
        // 疑问：什么是引入匹配，这里简单的理解就是可以动态的给 目标类添加属性或者接口..

        // AopUtils.canApply(Pointcut , null,null);

        // 判断一个建议(advisor)能否匹配一个指定的类型；
        // AopUtils.canApply(Advisor , null);
        // AopUtils.canApply(Advisor , null,null);
        // 在一组建议(advisor)中，返回能够匹配指定类型的建议者列表；
        // AppUtils.findAdvisorsThatCanApply(null,null)

    }


}
