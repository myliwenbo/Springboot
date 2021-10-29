package cn.lwb.Filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 过滤器，需要在XML中进行配置才能使用
 * @author lwb
 *
 */
public class ResoueFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException,
                                                             IOException {
        System.out.println("开始过滤器" + new Date().getTime());
        filterChain.doFilter(request, response);
        System.out.println("结束过滤器" + new Date().getTime());
    }

}
