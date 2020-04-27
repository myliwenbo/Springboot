package vip.xjdai.interceotor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义拦截器-方法拦截器，基于注解的AspectJ方式
 *
 * @author lwb
 */
@Component
@Aspect
public class CustomAutoAspectJInterceptor {
    private Logger logger = LoggerFactory.getLogger(CustomAutoAspectJInterceptor.class);

    @Around("execution (* vip.xjdai.*.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        logger.info(
                "CustomAutoAspectJInterceptor ==> invoke method: process method class is {}",
                point.getTarget().getClass());

        return point.proceed();
    }
}