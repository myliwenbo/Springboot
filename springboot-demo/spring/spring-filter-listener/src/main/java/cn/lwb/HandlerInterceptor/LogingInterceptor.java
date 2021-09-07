package cn.lwb.HandlerInterceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 拦截器
 * @author lwb
 *
 */
public class LogingInterceptor extends HandlerInterceptorAdapter {

    /**
     * controller执行之前调用这个方法
     * 返回true继续执行（如调用下一个拦截器或处理器）；
     * 返回false终止执行，此时我们需要通过response来产生响应；
     * 这里可以加入登录校验、权限拦截等
     */
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                             Object arg2) throws Exception {
        System.out.println("拦截器：" + new Date().getTime());
        return true;

    }
}
