package vip.xjdai.utils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import vip.xjdai.model.BaseConstants;
import vip.xjdai.model.BaseResult;
import vip.xjdai.model.JwtAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class InterceptorConfig extends HandlerInterceptorAdapter
{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        BaseResult result = null;
        //获取请求uri
        String requestURI = request.getRequestURI();
        if (requestURI.equals("/jwt/login")) {
            return true;
        }
        //获取认证token
        String jwt = request.getHeader(BaseConstants.AUTHORIZATION);
        //不传认证token，判断为无效请求
        if (StringUtils.isBlank(jwt)) {
            System.out.println("不能传递空的TOKEN");
            return false;
        }
        //其他请求均需验证token有效性
        JwtAccount jwtAccount = null;
        String     payload    = null;
        try {
            // 解析Payload
            payload = JsonWebTokenUtil.parseJwtPayload(jwt);
            //取出payload中字段信息
            if (payload.charAt(0) == '{' && payload.charAt(payload.length() - 1) == '}') {
                Map< String, Object > payloadMap = JsonWebTokenUtil.readValue(payload);
                //客户标识(userId)
                String subject = (String) payloadMap.get("sub");
                //查询用户签发秘钥
            }
            //验签token
            jwtAccount = JsonWebTokenUtil.parseJwt(jwt, JsonWebTokenUtil.SECRET_KEY);
        } catch (SignatureException | UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e) {
            throw new RuntimeException("令牌错误");
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("令牌过期");
        } catch (Exception e) {
            throw new RuntimeException("解析异常");
        }
        if (null == jwtAccount) {
            throw new RuntimeException("验签错误");
        }
        //将用户信息放入threadLocal中,线程共享
        ThreadLocalUtil.getInstance().bind(jwtAccount.getUserId());
        return true;
    }
}