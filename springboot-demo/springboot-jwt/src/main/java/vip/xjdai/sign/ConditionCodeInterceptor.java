package vip.xjdai.sign;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ConditionCodeInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object o) throws Exception {

        String token = request.getHeader("token");
        if (!org.springframework.util.StringUtils.isEmpty(token)) {
            //校验
            Boolean verify = SignUtil.verify(token);
            if (verify) {
                return true;
            }
        }

        return false;
    }

}
