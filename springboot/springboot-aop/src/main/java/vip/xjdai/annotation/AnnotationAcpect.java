package vip.xjdai.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by lmb on 2018/9/5.
 */
@Aspect //表示当前类是一个切面类
@Component
public class AnnotationAcpect
{

    /**
     * {@link vip.xjdai.annotation.ServiceAnnotation}
     * 表达式：配置到当前类的所有方法
     */
    private static final String CLASS = "within(vip.xjdai.annotation.ServiceAnnotation) ";


    @Pointcut(CLASS) //表示当前注解是一个切点
    public void dynamic() {}

    /**
     * 前置通知
     * @param joinPoint
     * @throws Throwable
     */
    @Before("dynamic()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println( joinPoint.getThis());
        System.out.println(joinPoint.getTarget());
    }

}