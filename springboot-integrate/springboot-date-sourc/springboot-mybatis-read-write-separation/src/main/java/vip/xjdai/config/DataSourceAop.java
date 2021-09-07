package vip.xjdai.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 动态切换数据源
 * @author lwb
 *
 */
@Aspect
@Component
public class DataSourceAop {

    /**
     * 匹配方法，以什么什么开头的
     */
    @Pointcut("!@annotation(vip.xjdai.config.Master) "
              + "&& (execution(* vip.xjdai.service..*.select*(..)) "
              + "|| execution(* vip.xjdai.service..*.get*(..)))")
    public void readPointcut() {

    }

    /**
     * 匹配方法 以什么什么开头的
     */
    @Pointcut("@annotation(vip.xjdai.config.Master) "
              + "|| execution(* vip.xjdai.service..*.insert*(..)) "
              + "|| execution(* vip.xjdai.service..*.add*(..)) "
              + "|| execution(* vip.xjdai.service..*.update*(..)) "
              + "|| execution(* vip.xjdai.service..*.edit*(..)) "
              + "|| execution(* vip.xjdai.service..*.delete*(..)) "
              + "|| execution(* vip.xjdai.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }

    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
    //    @Before("execution(* com.cjs.example.service.impl.*.*(..))")
    //    public void before(JoinPoint jp) {
    //        String methodName = jp.getSignature().getName();
    //
    //        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
    //            DBContextHolder.slave();
    //        }else {
    //            DBContextHolder.master();
    //        }
    //    }
}
