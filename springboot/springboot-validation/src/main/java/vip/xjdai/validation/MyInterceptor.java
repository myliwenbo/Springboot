package vip.xjdai.validation;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object o) throws Exception {
        //只有返回true才会继续向下执行，返回false取消当前请求
        System.out.println("myinterc prehandler");
        return true;
    }
}