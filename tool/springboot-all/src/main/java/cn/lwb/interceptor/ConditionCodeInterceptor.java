package cn.lwb.interceptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 特征码过滤器...
 * @author lwb
 *
 */
public class ConditionCodeInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory
        .getLogger(ConditionCodeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object o) throws Exception {
        String requestBody = getRequestBody(request.getInputStream());

        log.info(requestBody);
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

}
