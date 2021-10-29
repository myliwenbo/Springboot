package vip.xjdai.springbootspringutils.ClassUtils.getMostSpecificMethod;

import org.junit.Test;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;

/**
 * getMostSpecificMethod 演示
 */
public class getMostSpecificMethod {

    /**
     *  // 如果specificTargetClass为空，直接返回原始method。
     *  // 如果不为空，返回被代理的Class上的方法
     * @throws Exception
     */
    @Test
    public void getMostSpecificMethod() throws Exception {
        Method interfaceMethod = ClassUtils.getMethod(MethodInterface.class, "x");
        Method mostSpecificMethod = ClassUtils.getMostSpecificMethod(interfaceMethod, MethodInterfaceImpl.class);
        System.out.println(ClassUtils.getQualifiedMethodName(mostSpecificMethod));

    }
}

