package vip.xjdai.ioc.acpect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import vip.xjdai.ioc.utils.SpringContextUtil;

import java.lang.reflect.Field;

/**
 * Created by lmb on 2018/9/5.
 */
@Aspect //表示当前类是一个切面类
@Component
public class DynamicAcpect
{

    //表达式：配置到当前类的所有方法
    private static final String CLASS = "within(vip.xjdai.ioc.controller.DynamicController) ";

    @Pointcut(CLASS) //表示当前注解是一个切点
    public void dynamic() {

    }

    /**
     * 前置通知
     * @param joinPoint
     * @throws Throwable
     */
    @Before("dynamic()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        Object target = joinPoint.getTarget();
        Class<? extends Object> clazz = target.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            f.setAccessible(true); // 设置属性是可以访问的(私有的也可以)
            Class<?> type = f.getType();
            //判断是不是接口
            boolean interface1 = type.isInterface();
            if (interface1) {
                String name = f.getName();
                Object bean = SpringContextUtil.getBean(name + "2");
                f.set(target, bean);
            }
        }
    }

}