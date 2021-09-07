package vip.xjdai.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectClass{

    /**
     * {@link vip.xjdai.annotation.ServiceAnnotation}
     * 表达式：配置到当前类的所有方法
     */
    private static final String CLASS = "within(vip.xjdai.annotation.ServiceAnnotation) ";


    @Pointcut(CLASS) //表示当前注解是一个切点
    public void dynamic() {}
     
}