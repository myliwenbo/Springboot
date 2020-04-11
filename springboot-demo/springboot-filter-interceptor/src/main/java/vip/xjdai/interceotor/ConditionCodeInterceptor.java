package vip.xjdai.interceotor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * HandlerInterceptorAdapter是  springMVC项目中的拦截器
 *
 * @author lwb
 */
public class ConditionCodeInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory
            .getLogger(ConditionCodeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object o) throws Exception {
        String requestBody = getRequestBody(request.getInputStream());
        log.info(ConditionCodeInterceptor.class.getName());
        log.info(requestBody);
        requestBody = getRequestBody(request.getInputStream());
        log.info(requestBody);
        hasPermission(o);
        return true;
    }

    private String getRequestBody(InputStream stream) {
        String line = "";
        StringBuilder body = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        try {
            while ((line = reader.readLine()) != null) {
                body.append(line);
            }
        } catch (IOException e) {
            log.error("【业务处理】解析参数异常");
        }

        return body.toString();
    }

    private boolean hasPermission(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 获取方法上的注解 
            NoLogin method = handlerMethod.getMethod().getAnnotation(NoLogin.class);
            NoLogin clazz = handlerMethod.getMethod().getDeclaringClass()
                    .getAnnotation(NoLogin.class);
            // 如果方法上的注解为空 则获取类的注解    
            if (method == null && clazz == null) {
                return true;
            }
        }
        return false;
    }
}
