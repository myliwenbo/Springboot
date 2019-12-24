package vip.xjdai.log.acpect;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import vip.xjdai.log.bag.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by lmb on 2018/9/5.
 */
@Aspect //表示当前类是一个切面类
@Component
public class WebLogAcpect
{

    private              Logger logger  = LoggerFactory.getLogger(WebLogAcpect.class);
    //表达式：配置到当前包下所有类中的所有方法
    private static final String PACKAGE = "within(vip.xjdai.log.classz..*)";
    //表达式：配置到当前类的所有方法
    private static final String CLASS     = "within(vip.xjdai.log.classz.LogAOPClassz) ";
    //表达式：方法为pulic的任意返回值的任意方法名的任意参数都能匹配到
    private static final String POINT_CUT = "execution(public * vip.xjdai.log.execution.*.*(..))";
    //表达式：专门匹配该方法
    private static final String FUNCTION  = "execution(public * vip.xjdai.log.execution.LogAOPController.message(..))";

    @Before(PACKAGE)
    public void doBeforePackage(JoinPoint joinPoint) throws Throwable
    {
        logger.error("package通知");
    }

    /**
     * 定义切入点，切入点为 
     *  方法为：public
     *  返回值：任意
     *  package：cb.lwb.下的所有函数
     */
    @Pointcut(POINT_CUT) //表示当前注解是一个切点
    public void webLog()
    {
        logger.error("POINT_CUT通知");
    }

    @Before(CLASS)
    public void doBeforeClass(JoinPoint joinPoint) throws Throwable
    {
        logger.error("Class通知");
        ApiOperation apiOperation = giveController(joinPoint);
        String       value        = apiOperation.value();
        System.out.println(value);
    }

    @Before(FUNCTION)
    public void doBeforeMessage(JoinPoint joinPoint) throws Throwable
    {
        logger.error("MESSAGE通知");
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable
    {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest       request    = attributes.getRequest();
        //如果要获取Session信息的话，可以这样写：  
        //HttpSession session = request.getSession();
        //用的最多 通知的签名  
        Signature signature = joinPoint.getSignature();
        logger.info("请求URL : " + request.getRequestURL().toString());
        logger.info("请求方式HTTP_METHOD : " + request.getMethod());
        logger.info("请求IP : " + request.getRemoteAddr());
        //目标类.方法
        logger.info("CLASS_METHOD : " + signature.getDeclaringTypeName() + "." + signature.getName());
        logger.info("AOP参数: " + Arrays.toString(joinPoint.getArgs()));
        logger.info("AOP代理的Class信息：" + signature.getDeclaringType());
        logger.info("AOP代理类的信息   ：" + joinPoint.getThis());
        //代理的目标对象  
        logger.info("代理的目标对象  ：" + joinPoint.getTarget());
        //获取目标方法的参数信息  
        Object[] obj = joinPoint.getArgs();
        //获取请求参数
        Enumeration< String > enumeration  = request.getParameterNames();
        Map< String, String > parameterMap = Maps.newHashMap();
        while (enumeration.hasMoreElements()) {
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter, request.getParameter(parameter));
        }
        String str = JSON.toJSONString(parameterMap);
        if (obj.length > 0) {
            logger.info("请求的参数信息为：" + str);
        }
    }

    /**
     * 后置返回通知 
     * 这里需要注意的是: 
     *      如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息 
     *      如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数 
     *      returning：目标方法返回值与通知方法<返回值类型>相同时才执行，否则不执行
     *      returning：如果<通知方法>的参数为Object类型将匹配任何目标返回值。
     */

    @AfterReturning(value = "webLog()", returning = "keys", argNames = "keys")
    public void doAfterReturningAdvice2(JoinPoint joinPoint, String keys)
    {
        logger.info(Arrays.toString(joinPoint.getArgs()));
        logger.info("第二个后置返回通知的返回值：" + keys);
    }

    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) throws Throwable
    {
        logger.info("第一个后置返回通知的结果集 : " + ret);
    }

    /**
     *  throwing:限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行， 
     *           对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。 
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = "webLog()", throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception)
    {
        //目标方法名：  
        logger.info(joinPoint.getSignature().getName());
        logger.info("异常通知");
    }

    /**
     * 后置最终通知（目标方法只要执行完了就会执行后置通知方法） 
     * @param joinPoint
     */
    @After(value = "webLog()")
    public void doAfterAdvice(JoinPoint joinPoint)
    {
        logger.info("后置最终通知执行了!!!!");
    }

    /**
     * 环绕通知： 
     *   环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。 
     *   环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型 
     */
    @Around(value = "webLog()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint)
    {
        logger.info("环绕通知的目标方法名：" + proceedingJoinPoint.getSignature().getName());
        try {
            //增强方法
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    private static ApiOperation giveController(JoinPoint joinPoint)
    {
        Signature       signature       = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method          method          = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(ApiOperation.class);
        }
        return null;
    }
}