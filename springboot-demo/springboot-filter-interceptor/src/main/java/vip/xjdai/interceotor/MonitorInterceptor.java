package vip.xjdai.interceotor;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 方法拦截器
 *
 * @author lwb
 */
public class MonitorInterceptor implements MethodInterceptor {

    private static final Logger log = LoggerFactory.getLogger(MonitorInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        method.getName();
        Parameter[] parameters = method.getParameters();
        log.debug(Arrays.toString(parameters));
        log.debug(method.getName());
        return null;
    }

}